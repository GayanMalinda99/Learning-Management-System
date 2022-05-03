package com.example.backend.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCourseController {

    @GetMapping("api/v1/enrolecourse")
    public String enroleCourse(){
        return "Successfully enrolled";
    }
}
