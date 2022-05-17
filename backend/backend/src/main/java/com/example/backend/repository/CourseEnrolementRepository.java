package com.example.backend.repository;

import com.example.backend.course.model.CourseEnrolement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEnrolementRepository extends JpaRepository<CourseEnrolement, Integer> {
}
