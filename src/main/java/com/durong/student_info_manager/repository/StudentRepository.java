package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Serializable> {
    public List<Student> findByStudentId(String studentId);
    public List<Student> findByStudentName(String studentName);
    public List<Student> findByStudentAge(Integer studentAge);
    public List<Student> findByStudentNameAndStudentGender(String studentName, String studentGender);
}
