package com.geektrust.backend.repository;

import com.geektrust.backend.entites.Course;

import java.util.List;

public interface ICourseRegistrationRepository {
    public void save(String regId,Course course);
    public Course findCourseById(String regId);
    public void removeRegFromCourse(String regId);
    public List<String> findALlRegistrationByCourseId(String courseId);
}
