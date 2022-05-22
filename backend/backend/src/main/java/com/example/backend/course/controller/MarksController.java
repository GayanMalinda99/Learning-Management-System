package com.example.backend.course.controller;

import com.example.backend.appuser.AppUser;
import com.example.backend.appuser.AppUserRepository;
import com.example.backend.course.model.Course;
import com.example.backend.course.model.Marks;
import com.example.backend.course.repository.CourseRepository;
import com.example.backend.course.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class MarksController {
    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    /*@GetMapping("/marks")
    public Marks getMark(@RequestParam String course_code, @RequestParam Long student_id) {
        return marksRepository.findByCourseCodeAndStudentId(course_code,student_id);
    }*/

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
    @PostMapping("/marks")
    @PreAuthorize("hasRole('LECTURER')")
    public Marks saveMarks(@RequestBody Marks marks){
        return marksRepository.save(marks);
    }

    @GetMapping("/marks/{student_id}")
    @PreAuthorize("hasRole('STUDENT')")
    public List<Marks> getMarksByStudentId(@PathVariable long student_id){
        return marksRepository.findByStudentid(student_id);
    }

}
