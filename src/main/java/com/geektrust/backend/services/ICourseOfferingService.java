package com.geektrust.backend.services;

import com.geektrust.backend.exceptions.InvalidOperationException;

public interface ICourseOfferingService {
    public String addCourses(String courseName, String instructorName, String eventDate,int minEmp,int maxEmp) throws InvalidOperationException;
}
