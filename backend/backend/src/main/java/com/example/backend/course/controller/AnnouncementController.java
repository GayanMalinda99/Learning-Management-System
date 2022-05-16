package com.example.backend.course.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class AnnouncementController {

    @PostMapping("announcement/{announce}")
    public void getAnnouncement(@PathVariable String announce){

        System.out.println(announce);
    }
}
