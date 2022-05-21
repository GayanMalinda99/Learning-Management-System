package com.example.backend.course.controller;

//import com.example.backend.email.EmailService;
import com.example.backend.course.model.Announcement;
import com.example.backend.course.model.StudentEnroll;
import com.example.backend.course.repository.AnnouncementRepository;
import com.example.backend.course.repository.StudentEnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class AnnouncementController {


    @Autowired
    private StudentEnrollRepository studentEnrollRepository;

    @Autowired
    private AnnouncementRepository announcementRepository;

    @PostMapping("/announcement")
    public Announcement saveAnnouncement(@RequestBody Announcement announcement){
        return announcementRepository.save(announcement);
    }
    @GetMapping("/announcement")
    public List<StudentEnroll> getEnrollStudent(){
        return studentEnrollRepository.findAll();
    }

    /*@GetMapping("/announcementHistory")
    public List<Announcement> getAnnouncement(){
        return announcementRepository.findAll();
    }*/

    @GetMapping("/announcement/{Id}")
    public List<Announcement> getAnnouncemnt(@PathVariable int Id){
        return announcementRepository.getAnnouncementByStudentID(Id);
    }



}
