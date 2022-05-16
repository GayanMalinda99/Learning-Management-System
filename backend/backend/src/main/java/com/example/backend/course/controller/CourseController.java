package com.example.backend.course.controller;

import com.example.backend.appuser.AppUser;
import com.example.backend.appuser.AppUserRepository;
import com.example.backend.course.model.Course;
import com.example.backend.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/getcourse")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @PostMapping("/addcourse")
    public void addCourse(@RequestBody Course courseData) {
        courseRepository.save(courseData);
    }

    //@PutMapping("/{courseCode}/students/{studentId}")
//    public Course addStudentToCourse(
//            @PathVariable String courseCode,
//            @PathVariable Long studentId){
//        Course course = courseRepository.findById(courseCode).get();
//        AppUser student = appUserRepository.findById(studentId).get();
//        course.enrolledStudents.add(student);
//        return courseRepository.save(course);
//    }

    @PutMapping("/{courseCode}/lecturer/{lecturerId}")
    public Course assignLecturerToCourse(
            @PathVariable String courseCode,
            @PathVariable Long lecturerId){
        Course course = courseRepository.findById(courseCode).get();
        AppUser lecturer = appUserRepository.findById(lecturerId).get();
        course.setLecturer(lecturer);
        return courseRepository.save(course);
    }

}
