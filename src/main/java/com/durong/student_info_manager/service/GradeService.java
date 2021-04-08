package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Grade;
import com.durong.student_info_manager.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public void create(Float gradeScore, Integer courseId, String studentId) {
        Grade grade = new Grade();
        grade.setGradeScore(gradeScore);
        grade.setCourseId(courseId);
        grade.setStudentId(studentId);
        gradeRepository.save(grade);
    }

    public void update(Float gradeScore, Integer courseId, String studentId) {
        Grade grade = gradeRepository.findById(studentId).orElse(null);
        if (grade != null) {
            grade.setGradeScore(gradeScore);
            grade.setCourseId(courseId);
            gradeRepository.save(grade);
        }

    }

    public void delete(String studentId) {
        gradeRepository.deleteById(studentId);
    }

    public List<Grade> findAll() {
        List<Grade> grades = new ArrayList<Grade>();
        gradeRepository.findAll().addAll(grades);
        return grades;
    }

    public List<Grade> findAllByCourseId(Integer courseId) {
        return new ArrayList<Grade>(gradeRepository.findByCourseId(courseId));
    }
}
