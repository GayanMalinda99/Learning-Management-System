package com.example.backend.course.repository;

import com.example.backend.course.model.StudentEnroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollRepository extends JpaRepository<StudentEnroll,String> {

}
