package com.example.backend.course.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Course {

    @Id
    private String course_code;
    private String course_name;
    private String course_description;

}
