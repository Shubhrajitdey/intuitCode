package com.geektrust.backend.commands;

import com.geektrust.backend.exceptions.InvalidOperationException;
import com.geektrust.backend.services.CourseOfferingService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@DisplayName("AddCourseCommand")
@ExtendWith(MockitoExtension.class)
public class AddCourseCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    CourseOfferingService courseOfferingService;
    @InjectMocks
    AddCourseCommand addCourseCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void fetchCourseIdWithAllData(){
        String courseName = "PYTHON";
        String instractor = "JOHN";
        String date = "05062022";
        int min = 1;
        int max = 3;
        String expectedOutput = "OFFERING-PYTHON-JOHN";
        when(courseOfferingService.addCourses(courseName,instractor,date,min,max)).thenReturn("OFFERING-PYTHON-JOHN");
        addCourseCommand.execute(Arrays.asList("ADD-COURSE-OFFERINGT",courseName,instractor,date,String.valueOf(min),String.valueOf(max)));
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
    @Test
    public void throwErrorWithWrongInput(){
        String courseName = "PYTHON";
        String expectedOutput = "INPUT_DATA_ERROR";
        doThrow(new InvalidOperationException(expectedOutput)).when(courseOfferingService).addCourses(null,null,null,0,0);
        addCourseCommand.execute(Arrays.asList("ADD-COURSE-OFFERINGT",courseName,"Joey",null));
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
