package com.example.backend.course.model;


import com.example.backend.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Marks {

    @EmbeddedId
    CourseMarksKey id;


    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private AppUser student;

    @ManyToOne
    @MapsId("courseCode")
    @JoinColumn(name = "course_code")
    private Course course;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    @ManyToOne
//    private Course course;
//    @ManyToOne
//    private AppUser student;
    private long marks;

}
