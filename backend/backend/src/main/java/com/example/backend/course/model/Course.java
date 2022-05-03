package com.example.backend.course.model;

import com.example.backend.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @ManyToMany(mappedBy = "course")
    private Set<AppUser> students;

    @OneToMany(mappedBy = "course")
    Set<Marks> Marks;
}
