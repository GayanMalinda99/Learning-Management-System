package com.example.backend.controller;

import com.example.backend.entity.Course;
import com.example.backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/course")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/addcourse")
    public String addCourse(@RequestBody Course courseData) {
        courseRepository.save(courseData);
        return "Add Successfully";
    }
}
