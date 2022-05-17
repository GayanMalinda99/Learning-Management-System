package com.example.backend.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseEnrolement {
    @Id
    private int studentId;
    private String code;
    private String course_name;
    private String course_description;

}
