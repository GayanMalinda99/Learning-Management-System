package com.example.backend.course.model;

import com.example.backend.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    @ManyToMany
    @JoinTable(name = "course_enrolled_students",
            joinColumns = @JoinColumn(name = "course_code", referencedColumnName = "enrolled_students_id"))
    private List<AppUser> appUsers = new ArrayList<>();

}
