package com.example.backend.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class StudentCourseController {

    @PostMapping("/enrolecourse")
    public String enroleCourse(){
        return "Successfully enrolled to course";
    }

    @GetMapping("/dropcourse")
    public String dropCourse(){
        return "Successfully unenrolled";
    }
}
