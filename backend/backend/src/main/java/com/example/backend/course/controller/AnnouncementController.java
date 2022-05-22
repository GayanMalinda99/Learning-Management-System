package com.example.backend.course.controller;

//import com.example.backend.email.EmailService;
import com.example.backend.appuser.AppUser;
import com.example.backend.course.model.Announcement;
import com.example.backend.course.model.Course;
import com.example.backend.course.model.StudentEnroll;
import com.example.backend.course.repository.AnnouncementRepository;
import com.example.backend.course.repository.CourseRepository;
import com.example.backend.course.repository.StudentEnrollRepository;
import com.example.backend.email.AnnouncementEmailSender;
import com.example.backend.email.AnnouncementSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class AnnouncementController {


    @Autowired
    private StudentEnrollRepository studentEnrollRepository;

    @Autowired
    private AnnouncementRepository announcementRepository;

    AnnouncementSender announce = new AnnouncementSender();

    @PostMapping("/announcement")
    public Announcement saveAnnouncement(@RequestBody Announcement announcement){
        announce.sendEmail(announcement);
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
