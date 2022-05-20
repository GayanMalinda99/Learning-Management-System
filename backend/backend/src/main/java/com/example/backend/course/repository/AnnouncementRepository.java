package com.example.backend.course.repository;

import com.example.backend.course.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    @Query(value = "SELECT A.* FROM student_enrolled S,announcement A WHERE S.course_code=A.course_code AND S.enrolled_students_id=?1",nativeQuery = true)
    List<Announcement> getAnnouncementByStudentID(int enrolled_students_id);

}
