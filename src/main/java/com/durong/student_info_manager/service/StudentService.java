package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Student;
import com.durong.student_info_manager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    /**
     *
     * @param studentId： 学生学号
     * @param studentName：学生姓名
     * @param studentPassword：登陆密码
     * @param studentAge：学生年龄
     * @param studentGender：学生性别
     * @param studentMajority：所属专业
     * @param studentClass：所属班级
     * @param studentNative：民族
     * @param studentAddress：家庭住址
     * @param studentIdCard：身份证号
     * @param studentPhone：联系方式
     * @param studentEmail：Email
     * @param studentProfile：头像
     */
    public void create(String studentId, String studentName, String studentPassword,
                       Integer studentAge, String studentGender, Integer studentMajority,
                       String studentClass, String studentNative, String studentAddress,
                       String studentIdCard, String studentPhone, String studentEmail, String studentProfile) {
        Student student = new Student();
        student.setStudentId(studentId);
        updateStudentInfo(studentName, studentPassword, studentAge, studentGender, studentMajority,
                studentClass, studentNative, studentAddress, studentIdCard, studentPhone, studentEmail, studentProfile,
                student);
    }

    public void update(String studentId, String studentName, String studentPassword,
                       Integer studentAge, String studentGender,
                       Integer studentMajority, String studentClass, String studentNative, String studentAddress,
                       String studentIdCard, String studentPhone, String studentEmail, String studentProfile) {
        studentRepository.findById(studentId).ifPresent(student -> updateStudentInfo(studentName, studentPassword, studentAge,
                studentGender, studentMajority, studentClass, studentNative, studentAddress,
                studentIdCard, studentPhone, studentEmail, studentProfile, student));

    }

    private void updateStudentInfo(String studentName, String studentPassword, Integer studentAge, String studentGender,
                                   Integer studentMajority, String studentClass,
                                   String studentNative, String studentAddress, String studentIdCard,
                                   String studentPhone, String studentEmail, String studentProfile,
                                   Student student) {
        student.setStudentName(studentName);
        student.setStudentPassword(studentPassword);
        student.setStudentAge(studentAge);
        student.setStudentGender(studentGender);
        student.setStudentGender(studentGender);
        student.setStudentMajority(studentMajority);
        student.setStudentClass(studentClass);
        student.setStudentNative(studentNative);
        student.setStudentAddress(studentAddress);
        student.setStudentIdCard(studentIdCard);
        student.setStudentPhone(studentPhone);
        student.setStudentEmail(studentEmail);
        student.setStudentProfile(studentProfile);
        studentRepository.save(student);
    }

    public void stuUpdate(String studentId, String studentPassword) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            student.setStudentPassword(studentPassword);
            studentRepository.save(student);
        }
    }

    public void delete(String studentId) {
        studentRepository.deleteById(studentId);
    }

    /**
     * 通过ID查找到学生
     * @param studentId：学生学号
     * @return：找到的学生<Student>
     */
    public Student findById(String studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public List<Student> findAllStudentsOfClassAndMajority(String studentClass, Integer studentMajority) {
        return new ArrayList<Student>(studentRepository.findByStudentClassAndStudentMajority(studentClass, studentMajority));
    }

    public List<Student> findAll() {
        return new ArrayList<Student>(studentRepository.findAll());
    }
}

