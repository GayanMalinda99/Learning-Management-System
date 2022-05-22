package com.example.backend.course.repository;

import com.example.backend.appuser.AppUser;
import com.example.backend.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> findByEnrolledStudents_id(Long id);

    List<Course> findByCode(String code);

    List<Course> findByLecturer(Long id);
}
