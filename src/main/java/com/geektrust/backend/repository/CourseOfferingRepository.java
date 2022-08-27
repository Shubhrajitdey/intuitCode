package com.geektrust.backend.repository;

import com.geektrust.backend.entites.Course;

import java.util.HashMap;
import java.util.Map;

public class CourseOfferingRepository implements ICourseOfferingRepository{
    private final Map<String,Course> courseMapById;

    public CourseOfferingRepository() {
        this.courseMapById = new HashMap<>();
    }

    @Override
    public void save(Course course) {
        this.courseMapById.put(course.getCourseId(),course);
    }

    @Override
    public Course findCourseById(String courseId) {
        return this.courseMapById.get(courseId);
    }
}
