package com.geektrust.backend.services;


import com.geektrust.backend.entites.Course;
import com.geektrust.backend.exceptions.CourseFullException;
import com.geektrust.backend.exceptions.RegistrationCancelException;
import com.geektrust.backend.repository.CourseOfferingRepository;
import com.geektrust.backend.repository.CourseRegistrationRepository;
import com.geektrust.backend.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@DisplayName("Course Enrollment Program")
@ExtendWith(MockitoExtension.class)
public class CourseEnrollmentServiceTest {
    @Mock
    CourseOfferingRepository courseOfferingRepository;
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    CourseRegistrationRepository courseRegistrationRepository;
    @InjectMocks
    CourseEnrollmentService courseEnrollmentService;

    @Test
    public void registerForCourse(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,3,false,false,"05062022");
        course.addEmployeeToCourse();
        when(courseOfferingRepository.findCourseById("OFFERING-PYTHON-JOHN")).thenReturn(course);
        String actual = courseEnrollmentService.registerForCourse("ANDY@GMAIL.COM","OFFERING-PYTHON-JOHN");
        String expected = "REG-COURSE-ANDY-PYTHON";
        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void throwCourseFullError(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,1,false,false,"05062022");
        course.addEmployeeToCourse();
        when(courseOfferingRepository.findCourseById("OFFERING-PYTHON-JOHN")).thenReturn(course);
        Assertions.assertThrows(CourseFullException.class,()->courseEnrollmentService.registerForCourse("ANDY@GMAIL.COM","OFFERING-PYTHON-JOHN"));
    }
    @Test
    public void regCancel(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,1,false,false,"05062022");
        when(courseRegistrationRepository.findCourseById("REG-COURSE-ANDY-PYTHON")).thenReturn(course);
        String expected = "REG-COURSE-ANDY-PYTHON CANCEL_ACCEPTED";
        String actual = courseEnrollmentService.registrationCancel("REG-COURSE-ANDY-PYTHON");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void throwRegCancel(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,1,false,false,"05062022");
        course.setAllotted(true);
        when(courseRegistrationRepository.findCourseById("REG-COURSE-ANDY-PYTHON")).thenReturn(course);
        Assertions.assertThrows(RegistrationCancelException.class,()->courseEnrollmentService.registrationCancel("REG-COURSE-ANDY-PYTHON"));
    }
}
