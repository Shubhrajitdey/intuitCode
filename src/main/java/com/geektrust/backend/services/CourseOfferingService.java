package com.geektrust.backend.services;

import com.geektrust.backend.constants.Constant;
import com.geektrust.backend.entites.Course;
import com.geektrust.backend.exceptions.InvalidOperationException;
import com.geektrust.backend.repository.ICourseOfferingRepository;

public class CourseOfferingService implements ICourseOfferingService{
    private ICourseOfferingRepository courseOffering;

    public CourseOfferingService(ICourseOfferingRepository courseOffering) {
        this.courseOffering = courseOffering;
    }

    @Override
    public String addCourses(String courseName, String instructorName, String eventDate, int minEmp, int maxEmp) throws InvalidOperationException {
        if(courseName==null || instructorName ==null || eventDate ==null || maxEmp == Constant.ZERO || minEmp == Constant.ZERO){
            throw new InvalidOperationException(Constant.INPUT_DATA_ERROR);
        }
        String courseId = Constant.OFFERING+courseName+"-"+instructorName;
        Course course = new Course(courseName,courseId,instructorName,minEmp,maxEmp,false,false,eventDate);
        courseOffering.save(course);
        return courseId;
    }
}
