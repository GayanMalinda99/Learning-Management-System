package com.example.backend.course.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "student_enrolled")
public class StudentEnroll {

    //@GeneratedValue(strategy = GenerationType.IDENTITY )
    private String course_code;
    @Id
    private int enrolled_students_id;
}
