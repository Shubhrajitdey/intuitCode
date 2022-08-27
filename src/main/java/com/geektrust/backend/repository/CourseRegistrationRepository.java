package com.geektrust.backend.repository;

import com.geektrust.backend.entites.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRegistrationRepository implements ICourseRegistrationRepository{
    private final Map<String,Course> courseRegMap;

    public CourseRegistrationRepository() {
        this.courseRegMap = new HashMap<>();
    }

    @Override
    public void save(String regId, Course course) {
        this.courseRegMap.put(regId,course);
    }

    @Override
    public Course findCourseById(String regId) {
        return this.courseRegMap.get(regId);
    }

    @Override
    public void removeRegFromCourse(String regId) {
        if(courseRegMap.containsKey(regId)){
            this.courseRegMap.remove(regId);
        }
    }

    @Override
    public List<String> findALlRegistrationByCourseId(String courseId) {
        List<String> regList = new ArrayList<>();
        for(String str:courseRegMap.keySet()){
            if(courseId.equals(courseRegMap.get(str).getCourseId())){
                regList.add(str);
            }
        }
        return regList;
    }
}
