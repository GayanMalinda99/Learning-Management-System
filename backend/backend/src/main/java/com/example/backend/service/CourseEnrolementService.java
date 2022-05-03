package com.example.backend.service;

import com.example.backend.course.model.CourseEnrolement;
import com.example.backend.dto.CourseEnrolementDTO;
import com.example.backend.repository.CourseEnrolementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CourseEnrolementService {

    @Autowired
    private CourseEnrolementRepository courseEnrolementRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CourseEnrolementDTO saveStudentEnrolledCourse(CourseEnrolementDTO courseEnrolementDTO) {
        courseEnrolementRepository.save(modelMapper.map(courseEnrolementDTO, CourseEnrolement.class));
        return courseEnrolementDTO;
    }
}
