package com.example.backend.email;

import com.example.backend.appuser.AppUser;
import com.example.backend.course.model.Announcement;
import com.example.backend.course.model.Course;
import com.example.backend.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementSender {

    @Autowired
    private CourseRepository courseRepository ;

    public void sendEmail(Announcement announcement){
        AnnouncementEmailSender announcementEmailSender = new AnnouncementEmailSender();

        String[] mailArr = {"tharakaariyarathna04@gmail.com", "lm10@gmail.com", "bigbenz01@gmail.com"} ;

        List<Course> course = courseRepository.findByCode(announcement.getCourse_code()) ;
        List<AppUser> students = new ArrayList<>(course.get(0).enrolledStudents) ;

        for(int i = 0 ; i < students.size() ; i++){
            announcementEmailSender.sendAnnouncement(students.get(i).getEmail()
                    , "Announcement", announcement.getAnnouncement());
        }
    }
}
