package com.durong.student_info_manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "teacher_info")
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    private String teacherId;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "teacher_password")
    private String teacherPassword;
    @Column(name = "teacher_age")
    private Integer teacherAge;
    @Column(name = "teacher_gender")
    private String teacherGender;
    @Column(name = "teacher_department")
    private String teacherDepartment;
    @Column(name = "teacher_native")
    private String teacherNative;
    @Column(name = "teacher_address")
    private String teacherAddress;
    @Column(name = "teacher_phone")
    private String teacherPhone;
    @Column(name = "teacher_email")
    private String teacherEmail;
    @Column(name = "teacher_profile")
    private String teacherProfile;

    public Teacher() {
    }

    public Teacher(String teacherId, String teacherName, String password,
                   Integer teacherAge, String teacherGender, String teacherDepartment,
                   String teacherNative, String teacherAddress, String teacherPhone,
                   String teacherEmail, String teacherProfile) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherPassword = password;
        this.teacherAge = teacherAge;
        this.teacherGender = teacherGender;
        this.teacherDepartment = teacherDepartment;
        this.teacherNative = teacherNative;
        this.teacherAddress = teacherAddress;
        this.teacherPhone = teacherPhone;
        this.teacherEmail = teacherEmail;
        this.teacherProfile = teacherProfile;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherDepartment() {
        return teacherDepartment;
    }

    public void setTeacherDepartment(String teacherDepartment) {
        this.teacherDepartment = teacherDepartment;
    }

    public String getTeacherNative() {
        return teacherNative;
    }

    public void setTeacherNative(String teacherNative) {
        this.teacherNative = teacherNative;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherProfile() {
        return teacherProfile;
    }

    public void setTeacherProfile(String teacherProfile) {
        this.teacherProfile = teacherProfile;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherAge=" + teacherAge +
                ", teacherGender='" + teacherGender + '\'' +
                ", teacherDepartment='" + teacherDepartment + '\'' +
                ", teacherNative='" + teacherNative + '\'' +
                ", teacherAddress='" + teacherAddress + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", teacherProfile='" + teacherProfile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return teacherId.equals(teacher.teacherId) && teacherName.equals(teacher.teacherName) &&
                teacherPassword.equals(teacher.teacherPassword) && teacherAge.equals(teacher.teacherAge) &&
                teacherGender.equals(teacher.teacherGender) && teacherDepartment.equals(teacher.teacherDepartment) &&
                teacherNative.equals(teacher.teacherNative) && teacherAddress.equals(teacher.teacherAddress) &&
                teacherPhone.equals(teacher.teacherPhone) && teacherEmail.equals(teacher.teacherEmail) &&
                teacherProfile.equals(teacher.teacherProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherName, teacherPassword, teacherAge, teacherGender, teacherDepartment,
                teacherNative, teacherAddress, teacherPhone, teacherEmail, teacherProfile);
    }
}
