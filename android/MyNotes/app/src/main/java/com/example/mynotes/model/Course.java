package com.example.mynotes.model;

import java.util.HashSet;
import java.util.Set;

public class Course {
    public String code;
    public String title;
    public String description;
    public AppUser lecturer ;

    public Set<AppUser> enrolledStudents ;

}

