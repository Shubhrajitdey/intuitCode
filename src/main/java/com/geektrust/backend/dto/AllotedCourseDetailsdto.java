package com.geektrust.backend.dto;

public class AllotedCourseDetailsdto {
    private final String regId;
    private final String empEmail;
    private final String courseId;
    private final String courseName;
    private final String courseInstractor;
    private final String courseDate;
    private final String status;

    public String getRegId() {
        return regId;
    }

    public AllotedCourseDetailsdto(String regId, String empEmail, String courseId, String courseName, String courseInstractor, String courseDate,String status) {
        this.regId = regId;
        this.empEmail = empEmail;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseInstractor = courseInstractor;
        this.courseDate = courseDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return regId +" "+empEmail+" "+courseId+" "+courseName+" "+courseInstractor+" "+courseDate+" "+status;
    }
}
