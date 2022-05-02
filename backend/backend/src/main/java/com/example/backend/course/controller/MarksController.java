package com.example.backend.course.controller;

import com.example.backend.course.model.Marks;
import com.example.backend.course.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarksController {
    @Autowired
    private MarksRepository marksRepository;

    @GetMapping("/marks")
    public Marks getMark(@RequestParam String course_code, @RequestParam Long student_id) {
        return marksRepository.findByCourseCodeAndStudentId(course_code,student_id);
    }

}
