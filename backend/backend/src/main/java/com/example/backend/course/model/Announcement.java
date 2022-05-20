package com.example.backend.course.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Announcement {
    @Id
    private String announcement;

    private String date;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "code")
    private String course_code;

    /*public Course getCourse(){
        return course;
    }*/


}
