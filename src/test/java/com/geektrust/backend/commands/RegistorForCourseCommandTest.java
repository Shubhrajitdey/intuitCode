package com.geektrust.backend.commands;

import com.geektrust.backend.dto.AllotedCourseDetailsdto;
import com.geektrust.backend.exceptions.CourseFullException;
import com.geektrust.backend.exceptions.InvalidOperationException;
import com.geektrust.backend.exceptions.RegistrationCancelException;
import com.geektrust.backend.services.CourseEnrollmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("Register for courses")
@ExtendWith(MockitoExtension.class)
public class RegistorForCourseCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    CourseEnrollmentService courseEnrollmentService;
    @InjectMocks
    RegisterForCourseCommand registerForCourseCommand;
    @Test
    public void registerForCourse(){
        String emailId = "ANDY@GMAIL.COM OFFERING-PYTHON-JOHN";
        String courseId = "OFFERING-PYTHON-JOHN";
        String expectedOutput = "REG-COURSE-ANDY-PYTHON ACCEPTED";
        when(courseEnrollmentService.registerForCourse(emailId,courseId)).thenReturn("REG-COURSE-ANDY-PYTHON");
        registerForCourseCommand.execute(Arrays.asList("REGISTER","ANDY@GMAIL.COM OFFERING-PYTHON-JOHN","OFFERING-PYTHON-JOHN"));
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
    @Test
    public void throwCourseFullException(){
        String emailId = "ANDY@GMAIL.COM OFFERING-PYTHON-JOHN";
        String courseId = "OFFERING-PYTHON-JOHN";
        String expectedOutput = "COURSE_FULL_ERROR";
        doThrow(new CourseFullException(expectedOutput)).when(courseEnrollmentService).registerForCourse(emailId,courseId);
        registerForCourseCommand.execute(Arrays.asList("REGISTER","ANDY@GMAIL.COM OFFERING-PYTHON-JOHN","OFFERING-PYTHON-JOHN"));
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
    @Test
    public void throwInvalidOperationException(){
        String emailId = "ANDY@GMAIL.COM OFFERING-PYTHON-JOHN";
        String courseId = "OFFERING-PYTHON-JOHN";
        String expectedOutput = "INPUT_DATA_ERROR";
        doThrow(new InvalidOperationException(expectedOutput)).when(courseEnrollmentService).registerForCourse(emailId,courseId);
        registerForCourseCommand.execute(Arrays.asList("REGISTER","ANDY@GMAIL.COM OFFERING-PYTHON-JOHN","OFFERING-PYTHON-JOHN"));
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
}
