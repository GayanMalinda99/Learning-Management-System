package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseEnrolementDTO {
    private int studentId;
    private String code;
    private String course_name;
    private String course_description;
}
