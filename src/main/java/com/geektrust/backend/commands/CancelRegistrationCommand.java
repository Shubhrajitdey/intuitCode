package com.geektrust.backend.commands;

import com.geektrust.backend.constants.Constant;
import com.geektrust.backend.exceptions.RegistrationCancelException;
import com.geektrust.backend.services.ICourseEnrollmentService;

import java.util.List;

public class CancelRegistrationCommand implements ICommand{
    private final ICourseEnrollmentService courseEnrollmentService;

    public CancelRegistrationCommand(ICourseEnrollmentService courseEnrollmentService) {
        this.courseEnrollmentService = courseEnrollmentService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            String cancelStatus = courseEnrollmentService.registrationCancel(tokens.get(Constant.FIRST));
            System.out.println(cancelStatus);
        } catch (RegistrationCancelException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
