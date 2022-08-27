package com.geektrust.backend.repository;

import com.geektrust.backend.entites.Course;

public interface ICourseOfferingRepository {
    public void save(Course course);
    public Course findCourseById(String courseId);
}
