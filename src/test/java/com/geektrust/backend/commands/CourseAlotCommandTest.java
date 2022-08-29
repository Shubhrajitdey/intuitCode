package com.geektrust.backend.commands;

import com.geektrust.backend.dto.AllotedCourseDetailsdto;
import com.geektrust.backend.services.CourseEnrollmentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@DisplayName("Alot Courses")
@ExtendWith(MockitoExtension.class)
public class CourseAlotCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    CourseEnrollmentService courseEnrollmentService;
    @InjectMocks
    CourseAlotCommand courseAlotCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void alotCourse(){
        String courseId = "OFFERING-PYTHON-JOHN";
        String expectedOutput = "REG-COURSE-ANDY-PYTHON ANDY@GMAIL.COM OFFERING-PYTHON-JOHN PYTHON JOHN 05062022 CONFIRMED";
        AllotedCourseDetailsdto detailsdto = new AllotedCourseDetailsdto("REG-COURSE-ANDY-PYTHON","ANDY@GMAIL.COM","OFFERING-PYTHON-JOHN","PYTHON","JOHN","05062022","CONFIRMED");
        List<AllotedCourseDetailsdto> allotedCourseDetailsdtoList = new ArrayList<AllotedCourseDetailsdto>(){
            {
                add(detailsdto);
            }
        };
        doReturn(allotedCourseDetailsdtoList).when(courseEnrollmentService).allotCourseWithId(courseId);
        courseAlotCommand.execute(Arrays.asList("ALLOT","OFFERING-PYTHON-JOHN"));
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
