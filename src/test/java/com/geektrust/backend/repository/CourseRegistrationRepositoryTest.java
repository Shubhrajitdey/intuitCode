package com.geektrust.backend.repository;

import com.geektrust.backend.entites.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Course Registraton Repository")
public class CourseRegistrationRepositoryTest {
    private CourseRegistrationRepository courseRegistrationRepository;
    @BeforeEach
    public void setup(){
        courseRegistrationRepository = new CourseRegistrationRepository();
    }
    @Test
    public void getCourseByReg(){
        Course course = new Course("JAVA","OFFERING-JAVA-JOHN","JOHN",1,3,false,false,"26042022");
        courseRegistrationRepository.save("REG-COURSE-ANDY-JAVA",course);
        String expected = "Course-OFFERING-JAVA-JOHN";
        String actual = courseRegistrationRepository.findCourseById("REG-COURSE-ANDY-JAVA").toString();
        Assertions.assertEquals(expected,actual);
    }
}
