package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.CommandInvoker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Appconfig Test")
public class applicationConfigTest {
    private ApplicationConfig applicationConfig;
    @BeforeEach
    void setup(){
        applicationConfig = new ApplicationConfig();
    }
    @Test
    @DisplayName("Return Command Invoker")
    public void returnCommandInvoker(){
        CommandInvoker commandInvoker=applicationConfig.getCommandInvoker();
        assertNotNull(commandInvoker);
    }
}
