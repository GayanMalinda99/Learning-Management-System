package com.example.backend.entity;

import com.example.backend.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Course {

    @Id
    private String code;
    private String name;
    private String description;
    @ManyToOne
    private AppUser lecture;
}
