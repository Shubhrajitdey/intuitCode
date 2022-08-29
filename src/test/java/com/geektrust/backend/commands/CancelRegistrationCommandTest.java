package com.geektrust.backend.commands;

import com.geektrust.backend.exceptions.InvalidOperationException;
import com.geektrust.backend.exceptions.RegistrationCancelException;
import com.geektrust.backend.services.CourseEnrollmentService;
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

@DisplayName("Cancel the Registration")
@ExtendWith(MockitoExtension.class)
public class CancelRegistrationCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    CourseEnrollmentService courseEnrollmentService;
    @InjectMocks
    CancelRegistrationCommand cancelRegistrationCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void cancelRegistration(){
        String regId = "REG-COURSE-BOBY-PYTHON";
        String expectedOutput = "OFFERING-PYTHON-JOHN CANCEL_ACCEPTED";
        when(courseEnrollmentService.registrationCancel(regId)).thenReturn("OFFERING-PYTHON-JOHN CANCEL_ACCEPTED");
        cancelRegistrationCommand.execute(Arrays.asList("CANCEL","REG-COURSE-BOBY-PYTHON"));
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
    @Test
    public void throwErrorWithWrongInput(){
        String regId = "REG-COURSE-BOBY-PYTHON";
        String expectedOutput = "REG-COURSE-BOBY-PYTHON CANCEL_REJECTED";
        doThrow(new RegistrationCancelException(expectedOutput)).when(courseEnrollmentService).registrationCancel(regId);
        cancelRegistrationCommand.execute(Arrays.asList("CANCEL","REG-COURSE-BOBY-PYTHON"));
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
