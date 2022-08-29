package com.geektrust.backend.entites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Course Test")
public class CourseTest {

    @Test
    public void getCourseTitleFromCourse(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,3,false,false,"05062022");
        String expected = "PYTHON";
        String actual = course.getCourseTitle();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getCourseIdFromCourse(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,3,false,false,"05062022");
        String expected = "OFFERING-PYTHON-JOHN";
        String actual = course.getCourseId();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getInstructorNameFromCourse(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,3,false,false,"05062022");
        String expected = "JOHN";
        String actual = course.getInstructorName();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getMinCapacityFromCourse(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,3,false,false,"05062022");
        int expected = 1;
        int actual = course.getMinCapacity();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getMaxCapacityFromCourse(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,3,false,false,"05062022");
        int expected = 3;
        int actual = course.getMaxCapacity();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getCourseDate(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,3,false,false,"05062022");
        String expected = "05062022";
        String actual = course.getCourseDate();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getTotalRegEmployee(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,3,false,false,"05062022");
        course.addEmployeeToCourse();
        int expected = 1;
        int actual = course.getTotalRegistration();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getAlloted(){
        Course course = new Course("PYTHON","OFFERING-PYTHON-JOHN","JOHN",1,3,false,false,"05062022");
        course.setAllotted(true);
        boolean expected = true;
        boolean actual = course.isAllotted();
        Assertions.assertEquals(expected,actual);
    }
}
