package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.*;
import com.geektrust.backend.repository.*;
import com.geektrust.backend.services.CourseEnrollmentService;
import com.geektrust.backend.services.CourseOfferingService;
import com.geektrust.backend.services.ICourseEnrollmentService;
import com.geektrust.backend.services.ICourseOfferingService;

public class ApplicationConfig {

    private final ICourseOfferingRepository courseOfferingRepository = new CourseOfferingRepository();
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();
    private final ICourseRegistrationRepository courseRegistrationRepository = new CourseRegistrationRepository();
    private final ICourseOfferingService courseOfferingService = new CourseOfferingService(courseOfferingRepository);
    private final ICourseEnrollmentService courseEnrollmentService = new CourseEnrollmentService(courseOfferingRepository,courseRegistrationRepository,employeeRepository);
    private final AddCourseCommand addCourseCommand = new AddCourseCommand(courseOfferingService);
    private final CancelRegistrationCommand cancelRegistrationCommand = new CancelRegistrationCommand(courseEnrollmentService);
    private final CourseAlotCommand courseAlotCommand = new CourseAlotCommand(courseEnrollmentService);
    private final RegisterForCourseCommand registerForCourseCommand = new RegisterForCourseCommand(courseEnrollmentService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("ADD-COURSE-OFFERING",addCourseCommand);
        commandInvoker.register("REGISTER",registerForCourseCommand);
        commandInvoker.register("ALLOT",courseAlotCommand);
        commandInvoker.register("CANCEL",cancelRegistrationCommand);
        return commandInvoker;
    }
}
