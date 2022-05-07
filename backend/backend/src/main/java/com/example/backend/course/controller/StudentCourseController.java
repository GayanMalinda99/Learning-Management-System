package com.example.backend.course.controller;

import com.example.backend.dto.CourseEnrolementDTO;
import com.example.backend.service.CourseEnrolementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentCourseController {
    @Autowired
    private CourseEnrolementService courseEnrolementService;

    @PostMapping("/enrolCourse")
    public CourseEnrolementDTO enroleCourse(@RequestBody CourseEnrolementDTO courseEnrolementDTO){
        System.out.println("Enrollment Success!");
        return courseEnrolementService.saveStudentEnrolledCourse(courseEnrolementDTO);
    }

    @GetMapping("/registeredCourses")
    public List<CourseEnrolementDTO> getRegisteredCourses() {
        return courseEnrolementService.getEnrolledCourses();
    }

    @DeleteMapping("/dropCourse")
    public boolean dropCourse(@RequestBody CourseEnrolementDTO courseEnrolementDTO){
        return courseEnrolementService.dropCourse(courseEnrolementDTO);
    }
}
