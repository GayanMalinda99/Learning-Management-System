package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEnrolementRepository extends JpaRepository<CourseEnrolement, studentId> {

}
