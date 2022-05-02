package com.example.backend.course.model;

import com.example.backend.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Course {

    @Id
    private String code;
    private String title;
    private String description;
    @ManyToOne
    private AppUser lecturer;
    @ManyToMany
    private List<AppUser> students;
}
