package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Serializable> {
//    public List<Grade> findByGradeId(Integer gradeId);
//
//    public List<Grade> findByGradeName(Integer gradeName);
//
//    public List<Grade> findByStudentId(Integer studentId);
//
//    public List<Grade> findByCourseId(Integer courseId);
}
