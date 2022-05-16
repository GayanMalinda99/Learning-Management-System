package com.example.backend.course.controller;

import com.example.backend.dto.CourseEnrollmentDTO;
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
    public CourseEnrollmentDTO enroleCourse(@RequestBody CourseEnrollmentDTO courseEnrollmentDTO){
        System.out.println("Enrollment Success!");
        return courseEnrolementService.saveStudentEnrolledCourse(courseEnrollmentDTO);
    }

    @GetMapping("/registeredCourses")
    public List<CourseEnrollmentDTO> getRegisteredCourses() {
        return courseEnrolementService.getEnrolledCourses();
    }

    @DeleteMapping("/dropCourse")
    public boolean dropCourse(@RequestBody CourseEnrollmentDTO courseEnrollmentDTO){
        return courseEnrolementService.dropCourse(courseEnrollmentDTO);
    }
}
