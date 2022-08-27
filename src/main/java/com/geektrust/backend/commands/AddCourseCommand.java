package com.geektrust.backend.commands;

import com.geektrust.backend.constants.Constant;
import com.geektrust.backend.exceptions.InvalidOperationException;
import com.geektrust.backend.services.ICourseEnrollmentService;
import com.geektrust.backend.services.ICourseOfferingService;

import java.util.List;

public class AddCourseCommand implements ICommand{

    private final ICourseOfferingService courseOfferingService;

    public AddCourseCommand(ICourseOfferingService courseOfferingService) {
        this.courseOfferingService = courseOfferingService;
    }

    @Override
    public void execute(List<String> tokens) {
        if(tokens.size()<6){
            try {
                courseOfferingService.addCourses(null,null,null,0,0);
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }
        }else{
            String courseId = courseOfferingService.addCourses(tokens.get(Constant.FIRST),tokens.get(Constant.SECOND),tokens.get(Constant.THIRD),Integer.parseInt(tokens.get(Constant.FOUR)),Integer.parseInt(tokens.get(Constant.FIVE)));
            System.out.println(courseId);
        }
    }
}
