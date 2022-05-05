package com.example.backend.course.controller;

import com.example.backend.course.announcements.AnnouncementEmailSender;
import com.example.backend.email.EmailSender;
import com.example.backend.email.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class AnnouncementController {
    @Autowired
    private AnnouncementEmailSender announcementEmailSender ;

    /*@EventListener(ApplicationReadyEvent.class)
    public void sendEmail(String receiver, String subject, String body){
        announcementEmailSender.sendAnnouncement("1","2","3");
    }*/

    String[] mailArr = {"tharakaariyarathna04@gmail.com", "lm10@gmail.com", "bigbenz01@gmail.com"} ;

    @PostMapping("announcement/{announce}")
    public void getAnnouncement(@PathVariable String announce){
        for(int i = 0 ; i < mailArr.length ; i++){
            announcementEmailSender.sendAnnouncement(mailArr[i], "Announcement", announce);
        }
        System.out.println(announce);
    }
}
