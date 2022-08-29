package com.geektrust.backend.entites;

import java.util.HashMap;
import java.util.Map;

public class Course {
    private final String courseTitle;
    private final String courseId;
    private final String instructorName;
    private final int minCapacity;
    private final int maxCapacity;
    private boolean isAllotted;
    private boolean isCancelled;
    private final String courseDate;
    private int totalRegistration;



    public Course(String courseTitle, String courseId, String instructorName, int minCapacity, int maxCapacity, boolean isAllotted, boolean isCancelled, String courseDate) {
        this.courseTitle = courseTitle;
        this.courseId = courseId;
        this.instructorName = instructorName;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.isAllotted = isAllotted;
        this.isCancelled = isCancelled;
        this.courseDate = courseDate;
        this.totalRegistration =0;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean isAllotted() {
        return isAllotted;
    }

    public void setAllotted(boolean allotted) {
        isAllotted = allotted;
    }

    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public int getTotalRegistration() {
        return totalRegistration;
    }

    public void addEmployeeToCourse(){
        this.totalRegistration++;
    }

    @Override
    public String toString() {
        return "Course-"+this.courseId;
    }
}
