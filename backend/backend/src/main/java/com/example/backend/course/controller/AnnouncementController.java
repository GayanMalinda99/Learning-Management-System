package com.example.backend.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnouncementController {

    @GetMapping("/announcement/{announce}")
    public void getAnnouncement(@RequestParam String announce){

        System.out.println(announce);
    }
}
