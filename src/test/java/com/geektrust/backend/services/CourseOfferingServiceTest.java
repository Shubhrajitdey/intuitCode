package com.geektrust.backend.services;

import com.geektrust.backend.exceptions.InvalidOperationException;
import com.geektrust.backend.repository.CourseOfferingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Course Offering Service")
@ExtendWith(MockitoExtension.class)
public class CourseOfferingServiceTest {
    @Mock
    CourseOfferingRepository courseOfferingRepository;
    @InjectMocks
    CourseOfferingService courseOfferingService;

    @Test
    public void addCourseToService(){
        String courseName = "PYTHON";
        String instractor = "JOHN";
        String date = "05062022";
        int min = 1;
        int max = 3;
        String expectedOutput = "OFFERING-PYTHON-JOHN";
        String actualOutput = courseOfferingService.addCourses(courseName,instractor,date,1,3);
        Assertions.assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void throwInvalidDataError(){
        String courseName = "PYTHON";
        String instractor = "JOHN";
        String date = "05062022";
        int min = 1;
        Assertions.assertThrows(InvalidOperationException.class,() ->courseOfferingService.addCourses(courseName,instractor,date,1,0) );

    }
}
