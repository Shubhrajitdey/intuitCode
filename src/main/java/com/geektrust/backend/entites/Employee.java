package com.geektrust.backend.entites;

import com.geektrust.backend.constants.Constant;
import com.geektrust.backend.exceptions.InvalidOperationException;

import java.util.regex.Pattern;

public class Employee {
    private final String empName;
    private final String empEmail;

    public Employee(String empEmail) throws InvalidOperationException {
        if(validatedEmail(empEmail)){
            this.empEmail = empEmail;
            this.empName = empEmail.split("@")[Constant.ZERO];
        }else{
            throw new InvalidOperationException(Constant.INPUT_DATA_ERROR);
        }

    }

    private boolean validatedEmail(String empEmail) {
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(Constant.VALID_EMAIL_ADDRESS_REGEX, Pattern.CASE_INSENSITIVE);
        if(VALID_EMAIL_ADDRESS_REGEX.matcher(empEmail).matches()){
            return true;
        }
        return false;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }
}
