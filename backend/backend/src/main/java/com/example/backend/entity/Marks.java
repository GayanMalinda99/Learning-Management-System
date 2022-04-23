package com.example.backend.entity;


import com.example.backend.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Course course;
    @ManyToOne
    private AppUser student;
    private long marks;

}
