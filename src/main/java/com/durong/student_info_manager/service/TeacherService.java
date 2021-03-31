package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Teacher;
import com.durong.student_info_manager.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public void create(String teacherId, String teacherName, String password,
                       Integer teacherAge, String teacherGender, Date teacherBirthDate,
                       String teacherDepartment, String teacherMajority,
                       String teacherClass, String teacherNative, String teacherAddress,
                       String teacherIdCard, String teacherPhone, String teacherEmail,
                       String teacherPolitical, String teacherProfile) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        updateTeacherInfo(teacherName, password, teacherAge, teacherGender,
                teacherDepartment, teacherNative, teacherAddress, teacherPhone,
                teacherEmail, teacherProfile, teacher);
    }

    public void update(String teacherId, String teacherName, String password,
                       Integer teacherAge, String teacherGender, Date teacherBirthDate,
                       String teacherDepartment, String teacherMajority,
                       String teacherClass, String teacherNative, String teacherAddress,
                       String teacherIdCard, String teacherPhone, String teacherEmail,
                       String teacherPolitical, String teacherProfile) {
        teacherRepository.findById(teacherId).ifPresent(teacher -> updateTeacherInfo(
                teacherName, password, teacherAge, teacherGender, teacherDepartment, teacherNative,
                teacherAddress, teacherPhone, teacherEmail, teacherProfile, teacher));

    }

    private void updateTeacherInfo(
            String teacherName, String password, Integer teacherAge,
            String teacherGender, String teacherDepartment, String teacherNative,
            String teacherAddress, String teacherPhone, String teacherEmail,
            String teacherProfile,
            Teacher teacher) {
        teacher.setTeacherName(teacherName);
        teacher.setTeacherPassword(password);
        teacher.setTeacherAge(teacherAge);
        teacher.setTeacherGender(teacherGender);
        teacher.setTeacherGender(teacherGender);
        teacher.setTeacherDepartment(teacherDepartment);
        teacher.setTeacherNative(teacherNative);
        teacher.setTeacherAddress(teacherAddress);
        teacher.setTeacherPhone(teacherPhone);
        teacher.setTeacherEmail(teacherEmail);
        teacher.setTeacherProfile(teacherProfile);
        teacherRepository.save(teacher);
    }

    public void stuUpdate(String teacherId, String password) {
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        if (teacher != null) {
            teacher.setTeacherPassword(password);
            teacherRepository.save(teacher);
        }
    }

    public void delete(String teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    public Teacher findById(String teacherId) {
        return teacherRepository.findById(teacherId).orElse(null);
    }

//    public List<Teacher> findAllTeachersOfGrade(String department, String major, Long gradeId) {
//        List<Teacher> teachers = new ArrayList<Teacher>();
//        Iterator<Teacher> it = teacherRepository.findTeachersByDepartmentAndMajorAndGrade(department, major, gradeId).iterator();
//        while (it.hasNext()) {
//            Teacher teacher = it.next();
//            teachers.add(teacher);
//        }
//        return teachers;
//    }

    public List<Teacher> findAll() {
        List<Teacher> teachers = new ArrayList<Teacher>();
        teacherRepository.findAll().addAll(teachers);
        return teachers;
    }
}
