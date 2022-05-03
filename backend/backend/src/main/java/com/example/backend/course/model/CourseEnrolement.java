package com.example.backend.course.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CourseEnrolement {

    @Id
    private int studentId;

}
