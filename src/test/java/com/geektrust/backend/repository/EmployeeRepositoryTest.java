package com.geektrust.backend.repository;

import com.geektrust.backend.entites.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Employee Repositoty")
public class EmployeeRepositoryTest {
    private EmployeeRepository employeeRepository;
    @BeforeEach
    public void setup(){
        employeeRepository = new EmployeeRepository();
    }
    @Test
    public void getEmployeeByReg(){
        Employee employee = new Employee("ANDY@GMAIL.COM");
        employeeRepository.save("REG-COURSE-ANDY-PYTHON","ANDY@GMAIL.COM");
        String expected = "ANDY@GMAIL.COM";
        String actual = employeeRepository.findEmailByRegId("REG-COURSE-ANDY-PYTHON");
        Assertions.assertEquals(expected,actual);
    }
}
