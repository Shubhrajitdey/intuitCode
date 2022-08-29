package com.geektrust.backend.commands;

import com.geektrust.backend.constants.Constant;
import com.geektrust.backend.exceptions.CourseFullException;
import com.geektrust.backend.exceptions.InvalidOperationException;
import com.geektrust.backend.exceptions.MissingDataException;
import com.geektrust.backend.services.ICourseEnrollmentService;

import java.util.List;

public class RegisterForCourseCommand implements ICommand{

    private final ICourseEnrollmentService courseEnrollmentService;

    public RegisterForCourseCommand(ICourseEnrollmentService courseEnrollmentService) {
        this.courseEnrollmentService = courseEnrollmentService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            if(tokens.size()<3){
                System.out.println(Constant.INPUT_DATA_ERROR);
            }else{
                String registrationId = courseEnrollmentService.registerForCourse(tokens.get(Constant.FIRST),tokens.get(Constant.SECOND));
                System.out.println(registrationId+" "+Constant.ACCEPTED);
            }
        } catch (CourseFullException e) {
            System.out.println(e.getMessage());
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
