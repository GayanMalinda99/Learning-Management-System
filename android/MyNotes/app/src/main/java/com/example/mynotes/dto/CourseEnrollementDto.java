package com.example.mynotes.dto;

public class CourseEnrollementDto {
    private int studentId;
    private String code;
    private String course_name;
    private String course_description;

    public String getCourseName(){
        return course_name ;
    }

    public String getCode(){
        return code ;
    }

    public String getStudentId(){
        return Integer.toString(studentId) ;
    }

    public String getCourseDescription(){
        return course_description ;
    }
}
