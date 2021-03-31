package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Student;
import com.durong.student_info_manager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void create(String studentId, String studentName, String password,
                       Integer studentAge, String studentGender, Date studentBirthDate,
                       String studentDepartment, String studentMajority,
                       String studentClass, String studentNative, String studentAddress,
                       String studentIdCard, String studentPhone, String studentEmail,
                       String studentPolitical, String studentProfile) {
        Student student = new Student();
        student.setStudentId(studentId);
        updateStudentInfo(studentName, password, studentAge, studentGender, studentBirthDate, studentDepartment, studentMajority, studentClass, studentNative, studentAddress, studentIdCard, studentPhone, studentEmail, studentPolitical, studentProfile, student);
    }

    public void update(String studentId, String studentName, String password,
                       Integer studentAge, String studentGender, Date studentBirthDate,
                       String studentDepartment, String studentMajority,
                       String studentClass, String studentNative, String studentAddress,
                       String studentIdCard, String studentPhone, String studentEmail,
                       String studentPolitical, String studentProfile) {
        studentRepository.findById(studentId).ifPresent(student -> updateStudentInfo(studentName, password, studentAge, studentGender, studentBirthDate, studentDepartment, studentMajority, studentClass, studentNative, studentAddress, studentIdCard, studentPhone, studentEmail, studentPolitical, studentProfile, student));

    }

    private void updateStudentInfo(String studentName, String password, Integer studentAge, String studentGender, Date studentBirthDate, String studentDepartment, String studentMajority, String studentClass, String studentNative, String studentAddress, String studentIdCard, String studentPhone, String studentEmail, String studentPolitical, String studentProfile, Student student) {
        student.setStudentName(studentName);
        student.setStudentPassword(password);
        student.setStudentAge(studentAge);
        student.setStudentGender(studentGender);
        student.setStudentGender(studentGender);
        student.setStudentBirthDate(studentBirthDate);
        student.setStudentDepartment(studentDepartment);
        student.setStudentMajority(studentMajority);
        student.setStudentClass(studentClass);
        student.setStudentNative(studentNative);
        student.setStudentAddress(studentAddress);
        student.setStudentIdCard(studentIdCard);
        student.setStudentPhone(studentPhone);
        student.setStudentEmail(studentEmail);
        student.setStudentPolitical(studentPolitical);
        student.setStudentProfile(studentProfile);
        studentRepository.save(student);
    }

    public void stuUpdate(String studentId, String password) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            student.setStudentPassword(password);
            studentRepository.save(student);
        }
    }

    public void delete(String studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student findById(String studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

//    public List<Student> findAllStudentsOfGrade(String department, String major, Long gradeId) {
//        List<Student> students = new ArrayList<Student>();
//        Iterator<Student> it = studentRepository.findStudentsByDepartmentAndMajorAndGrade(department, major, gradeId).iterator();
//        while (it.hasNext()) {
//            Student student = it.next();
//            students.add(student);
//        }
//        return students;
//    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().addAll(students);
        return students;
    }
}

