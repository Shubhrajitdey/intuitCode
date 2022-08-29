package com.geektrust.backend.repository;

import com.geektrust.backend.entites.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Course Offering")
public class CourseOfferingRepositoryTest {
    @Test
    public void courseOfferAdd(){
        Course course = new Course("JAVA","OFFERING-JAVA-JOHN","JOHN",1,3,false,false,"26042022");
        String expected = "Course-OFFERING-JAVA-JOHN";
        CourseOfferingRepository courseOfferingRepository = new CourseOfferingRepository();
        courseOfferingRepository.save(course);
        String actual = courseOfferingRepository.findCourseById("OFFERING-JAVA-JOHN").toString();
        Assertions.assertEquals(expected,actual);
    }
}
