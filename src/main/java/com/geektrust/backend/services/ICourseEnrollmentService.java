package com.geektrust.backend.services;

import com.geektrust.backend.dto.AllotedCourseDetailsdto;
import com.geektrust.backend.exceptions.*;

import java.util.List;


public interface ICourseEnrollmentService {
    public String registerForCourse(String empEmail,String courseId) throws CourseFullException, InvalidOperationException;
    public String registrationCancel(String registrationId) throws RegistrationCancelException;
    public List<AllotedCourseDetailsdto> allotCourseWithId(String courseId);
}
