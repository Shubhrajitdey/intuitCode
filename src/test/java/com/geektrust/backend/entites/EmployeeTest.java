package com.geektrust.backend.entites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("employee details")
public class EmployeeTest {
    @Test
    public void getEmployeeName(){
        Employee employee = new Employee("ANDY@GMAIL.COM");
        String expectedName = "ANDY";
        String actualName = employee.getEmpName();
        Assertions.assertEquals(expectedName,actualName);
    }
}
