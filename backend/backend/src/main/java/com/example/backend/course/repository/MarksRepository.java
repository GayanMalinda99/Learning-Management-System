package com.example.backend.course.repository;

import com.example.backend.course.model.CourseMarksKey;
import com.example.backend.course.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<Marks, CourseMarksKey> {
       Marks findByCourseCodeAndStudentId(String course_code, Long student_id);
}
