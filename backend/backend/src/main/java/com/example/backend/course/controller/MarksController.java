package com.example.backend.course.controller;

import com.example.backend.appuser.AppUser;
import com.example.backend.appuser.AppUserRepository;
import com.example.backend.course.model.Course;
import com.example.backend.course.model.Marks;
import com.example.backend.course.repository.CourseRepository;
import com.example.backend.course.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/marks")
public class MarksController {
    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/marks")
    public Marks getMark(@RequestParam String course_code, @RequestParam Long student_id) {
        return marksRepository.findByCourseCodeAndStudentId(course_code,student_id);
    }

//    @PutMapping("/{courseCode}/addmarks/{studentId}")
//    public void addMarks(
//            @PathVariable String courseCode,
//            @PathVariable Long studentId,
//            @RequestBody Marks marksData) {
//        Course course = courseRepository.findById(courseCode).get();
//        AppUser student = appUserRepository.findById(studentId).get();
//        course.
//        marksRepository.save(marksData);
//    }

}
