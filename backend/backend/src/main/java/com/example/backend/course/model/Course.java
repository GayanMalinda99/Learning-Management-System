package com.example.backend.course.model;

import com.example.backend.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Getter
@Setter
@Entity
public class Course {

    @Id
    private String code;
    private String course_name;
    private String course_description;
    @OneToOne
    private AppUser lecturer;

}
