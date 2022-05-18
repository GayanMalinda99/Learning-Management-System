package com.example.backend.course.controller;

//import com.example.backend.email.EmailService;
import com.example.backend.course.model.StudentEnroll;
import com.example.backend.course.repository.StudentEnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class AnnouncementController {


    @Autowired
    private StudentEnrollRepository studentEnrollRepository;

    @PostMapping("announcement/{announce}")
    public void getAnnouncement(@PathVariable String announce){

        System.out.println(announce);
    }
    @GetMapping("/announcement")
    public List<StudentEnroll> getEnrollStudent(){
        return studentEnrollRepository.findAll();
    }

}
