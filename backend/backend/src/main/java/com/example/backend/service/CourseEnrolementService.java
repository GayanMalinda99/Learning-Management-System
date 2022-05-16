package com.example.backend.service;

import com.example.backend.course.model.CourseEnrollment;
import com.example.backend.dto.CourseEnrollmentDTO;
import com.example.backend.repository.CourseEnrollmentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseEnrolementService {

    @Autowired
    private CourseEnrollmentRepository courseEnrollmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CourseEnrollmentDTO saveStudentEnrolledCourse(CourseEnrollmentDTO courseEnrollmentDTO) {
        courseEnrollmentRepository.save(modelMapper.map(courseEnrollmentDTO, CourseEnrollment.class));
        return courseEnrollmentDTO;
    }

    public List<CourseEnrollmentDTO> getEnrolledCourses(){
        List<CourseEnrollment>courseList= courseEnrollmentRepository.findAll();
        return modelMapper.map(courseList, new TypeToken<List<CourseEnrollmentDTO>>(){}.getType());
    }

    public boolean dropCourse(CourseEnrollmentDTO courseEnrollmentDTO) {
        courseEnrollmentRepository.delete(modelMapper.map(courseEnrollmentDTO, CourseEnrollment.class));
        return true;
    }
}
