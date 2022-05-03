package com.example.backend.course.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CourseEnrolement {

    @Id
    private int studentId;
    private String code;
    private String course_name;
    private String course_description;

}
