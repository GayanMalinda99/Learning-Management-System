package com.example.mynotes.dto;

public class CourseEnrollementDto {
    public int studentId;
    private String code;
    private String course_name;
    public String course_description;

    public String getCourseName(){
        return course_name ;
    }

    public String getCode(){
        return code ;
    }

    public String getStudentId(){
        return Integer.toString(studentId) ;
    }
}
