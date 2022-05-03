package com.example.backend.service;

import com.example.backend.dto.CourseEnrolementDTO;
import com.example.backend.repository.CourseEnrolementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CourseEnrolementService {

    @Autowired
    private CourseEnrolementRepository courseEnrolementRepository;
    public String saveStudentEnrolledCourse(CourseEnrolementDTO courseEnrolementDTO) {
        courseEnrolementRepository.save(courseEnrolementDTO);
    }
}
