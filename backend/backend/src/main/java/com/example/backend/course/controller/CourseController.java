package com.example.backend.course.controller;

import com.example.backend.course.model.Course;
import com.example.backend.course.repository.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private CourseRepository courseRepository;

    @GetMapping("/course")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
}
