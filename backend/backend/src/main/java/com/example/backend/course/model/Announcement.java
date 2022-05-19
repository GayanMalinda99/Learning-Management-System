package com.example.backend.course.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Announcement {
    @Id
    private String announcement;

    private String Date;

    @ManyToOne
    @JoinColumn(name = "course_code")
    private Course course;

    public Course getCourse(){
        return course;
    }


}
