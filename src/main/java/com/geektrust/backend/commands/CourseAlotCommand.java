package com.geektrust.backend.commands;

import com.geektrust.backend.constants.Constant;
import com.geektrust.backend.dto.AllotedCourseDetailsdto;
import com.geektrust.backend.services.ICourseEnrollmentService;

import java.util.List;

public class CourseAlotCommand implements ICommand{
    private final ICourseEnrollmentService courseEnrollmentService;

    public CourseAlotCommand(ICourseEnrollmentService courseEnrollmentService) {
        this.courseEnrollmentService = courseEnrollmentService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            List<AllotedCourseDetailsdto> allotedCourseDetailsdtos = courseEnrollmentService.allotCourseWithId(tokens.get(Constant.FIRST));
            allotedCourseDetailsdtos.forEach(System.out::println);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
