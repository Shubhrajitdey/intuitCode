package com.geektrust.backend.commands;

import com.geektrust.backend.exceptions.NoSuchCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyList;

@DisplayName("commandInvoker")
@ExtendWith(MockitoExtension.class)
public class CommandInvokerTest {
    private CommandInvoker commandInvoker;
    @Mock
    AddCourseCommand addCourseCommand;
    @Mock
    CancelRegistrationCommand cancelRegistrationCommand;
    @Mock
    CourseAlotCommand courseAlotCommand;
    @Mock
    RegisterForCourseCommand registerForCourseCommand;

    @BeforeEach
    void setup(){
        commandInvoker = new CommandInvoker();
        commandInvoker.register("ADD-COURSE-OFFERING",addCourseCommand);
        commandInvoker.register("REGISTER",registerForCourseCommand);
        commandInvoker.register("ALLOT",courseAlotCommand);
        commandInvoker.register("CANCEL",cancelRegistrationCommand);
    }
    @Test
    void executeCommandByToken(){
        commandInvoker.executeCommand("ADD-COURSE-OFFERING",anyList());
        commandInvoker.executeCommand("REGISTER",anyList());
        commandInvoker.executeCommand("ALLOT",anyList());
        commandInvoker.executeCommand("CANCEL",anyList());
    }
    @Test
    void executeCommandBycommandMismatch(){
        Assertions.assertThrows(NoSuchCommandException.class,() -> commandInvoker.executeCommand("RANDOM-COMMAND",new ArrayList<String>()));
    }
}
