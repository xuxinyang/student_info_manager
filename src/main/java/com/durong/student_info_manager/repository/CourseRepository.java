package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Serializable> {

    public List<Course> findByCourseStatus(String courseStatus);

    public List<Course> findByTeacherId(String teacherId);

}
