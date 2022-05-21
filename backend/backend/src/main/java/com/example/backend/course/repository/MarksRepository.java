package com.example.backend.course.repository;

import com.example.backend.course.model.CourseMarksKey;
import com.example.backend.course.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
       //Marks findByCourseCodeAndStudentId(String course_code, Long student_id);
    @Query(value = "SELECT * FROM marks WHERE student_id=?1",nativeQuery = true)
    List<Marks> findByStudentid(Long student_id);


}
