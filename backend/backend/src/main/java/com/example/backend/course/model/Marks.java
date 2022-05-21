package com.example.backend.course.model;


import com.example.backend.appuser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="marks")
public class Marks {
    @Id
    @GeneratedValue
    private int id;




    /*@EmbeddedId
    CourseMarksKey id;


    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private AppUser student;

    @ManyToOne
    @MapsId("courseCode")
    @JoinColumn(name = "course_code")
    private Course course;*/
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    @ManyToOne
//    private Course course;
//    @ManyToOne
//    private AppUser student;
        private long marks;
        private long student_id;
        private String course_code;

}
