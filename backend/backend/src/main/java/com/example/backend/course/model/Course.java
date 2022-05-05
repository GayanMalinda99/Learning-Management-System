package com.example.backend.course.model;

import com.example.backend.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private AppUser lecturer;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled")
    public
    Set<AppUser> enrolledStudents = new HashSet<>();

    @OneToMany(mappedBy = "course")
    Set<Marks> Marks;

    public Set<AppUser> getEnrolledStudents() {
        return enrolledStudents;
    }
}
