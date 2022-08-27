package com.geektrust.backend.services;

import com.geektrust.backend.constants.Constant;
import com.geektrust.backend.dto.AllotedCourseDetailsdto;
import com.geektrust.backend.entites.Course;
import com.geektrust.backend.entites.Employee;
import com.geektrust.backend.exceptions.*;
import com.geektrust.backend.repository.ICourseOfferingRepository;
import com.geektrust.backend.repository.ICourseRegistrationRepository;
import com.geektrust.backend.repository.IEmployeeRepository;

import java.util.*;
import java.util.stream.Collectors;


public class CourseEnrollmentService implements ICourseEnrollmentService{
    private final ICourseOfferingRepository courseOfferingRepository;
    private final ICourseRegistrationRepository courseRegistrationRepository;
    private final IEmployeeRepository employeeRepository;

    public CourseEnrollmentService(ICourseOfferingRepository courseOfferingRepository, ICourseRegistrationRepository courseRegistrationRepository, IEmployeeRepository employeeRepository) {
        this.courseOfferingRepository = courseOfferingRepository;
        this.courseRegistrationRepository = courseRegistrationRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String registerForCourse(String empEmail,String courseId) throws CourseFullException, InvalidOperationException {
        Course checkCourse = courseOfferingRepository.findCourseById(courseId);
        if(checkCourse.getTotalRegistration() == checkCourse.getMaxCapacity()){
            throw new CourseFullException(Constant.COURSE_FULL_ERROR);
        }
        try {
            Employee employee = new Employee(empEmail);
            String regId = Constant.REG_COURSE+employee.getEmpName()+"-"+checkCourse.getCourseTitle();
            checkCourse.addEmployeeToCourse();
            employeeRepository.save(regId,empEmail);
            courseRegistrationRepository.save(regId,checkCourse);
            return regId;
        }catch (InvalidOperationException e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public String registrationCancel(String registrationId) throws RegistrationCancelException {
        Course course = courseRegistrationRepository.findCourseById(registrationId);
        if(!course.isAllotted()){
            employeeRepository.removeRegById(registrationId);
            courseRegistrationRepository.removeRegFromCourse(registrationId);
        }else{
            throw new RegistrationCancelException(registrationId+" "+Constant.CANCEL_REJECTED);
        }
        return registrationId+" "+Constant.CANCEL_ACCEPTED;
    }

    @Override
    public List<AllotedCourseDetailsdto> allotCourseWithId(String courseId){
        Course course = courseOfferingRepository.findCourseById(courseId);
        if(course.getTotalRegistration()<course.getMinCapacity()){
            course.setCancelled(true);
        }else {
            course.setAllotted(true);
        }
        List<AllotedCourseDetailsdto> allotedCourseDetailsdtos = new ArrayList<>();
        for(String reg:courseRegistrationRepository.findALlRegistrationByCourseId(courseId)){
            AllotedCourseDetailsdto detailsdto;
            if(course.isAllotted()){
                detailsdto = new AllotedCourseDetailsdto(reg,employeeRepository.findEmailByRegId(reg),courseId,course.getCourseTitle(),course.getInstructorName(),course.getCourseDate(),Constant.CONFIRMED);

            }else{
                detailsdto = new AllotedCourseDetailsdto(reg,employeeRepository.findEmailByRegId(reg),courseId,course.getCourseTitle(),course.getInstructorName(),course.getCourseDate(),Constant.CANCELED);
            }
            allotedCourseDetailsdtos.add(detailsdto);
        }
        return allotedCourseDetailsdtos.stream().sorted((p1,p2)->p1.getRegId().compareTo(p2.getRegId())).collect(Collectors.toList());
    }
}
