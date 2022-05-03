package com.example.backend.course.controller;

import com.example.backend.course.model.Course;
import com.example.backend.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/course")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @PostMapping("/addcourse")
    public void addCourse(@RequestBody Course courseData) {
        courseRepository.save(courseData);
    }
}
