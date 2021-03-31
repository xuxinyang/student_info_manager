package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Serializable>  {
    public List<Teacher> findByTeacherId(String teacherId);
    public List<Teacher> findByTeacherName(String teacherName);
    public List<Teacher> findByTeacherAge(Integer teacherAge);
    public List<Teacher> findByTeacherNameAndTeacherGenderAndTeacherDepartment(
            String teacherName, String teacherGender, String teacherDepartment
    );
}
