package com.durong.student_info_manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "student_info")
public class Student {
    @Id
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_password")
    private String studentPassword;
    @Column(name = "student_age")
    private Integer studentAge;
    @Column(name = "student_gender")
    private String studentGender;
    @Column(name = "student_birthday")
    private Date studentBirthDate;
    @Column(name = "student_department")
    private String studentDepartment;
    @Column(name = "student_majority")
    private String studentMajority;
    @Column(name = "student_class")
    private String studentClass;
    @Column(name = "student_native")
    private String studentNative;
    @Column(name = "student_address")
    private String studentAddress;
    @Column(name = "student_id_card")
    private String studentIdCard;
    @Column(name = "student_phone")
    private String studentPhone;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "student_political")
    private String studentPolitical;
    @Column(name = "student_profile")
    private String studentProfile;

    public Student() {
    }

    public Student(String studentId, String studentName, String password,
                   Integer studentAge, String studentGender, Date studentBirthDate,
                   String studentDepartment, String studentMajority,
                   String studentClass, String studentNative, String studentAddress,
                   String studentIdCard, String studentPhone, String studentEmail,
                   String studentPolitical, String studentProfile) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPassword = password;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentBirthDate = studentBirthDate;
        this.studentDepartment = studentDepartment;
        this.studentMajority = studentMajority;
        this.studentClass = studentClass;
        this.studentNative = studentNative;
        this.studentAddress = studentAddress;
        this.studentIdCard = studentIdCard;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
        this.studentPolitical = studentPolitical;
        this.studentProfile = studentProfile;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Date getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(Date studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public String getStudentMajority() {
        return studentMajority;
    }

    public void setStudentMajority(String studentMajority) {
        this.studentMajority = studentMajority;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentNative() {
        return studentNative;
    }

    public void setStudentNative(String studentNative) {
        this.studentNative = studentNative;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentIdCard() {
        return studentIdCard;
    }

    public void setStudentIdCard(String studentIdCard) {
        this.studentIdCard = studentIdCard;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPolitical() {
        return studentPolitical;
    }

    public void setStudentPolitical(String studentPolitical) {
        this.studentPolitical = studentPolitical;
    }

    public String getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(String studentProfile) {
        this.studentProfile = studentProfile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentAge=" + studentAge +
                ", studentGender='" + studentGender + '\'' +
                ", studentBirthDate=" + studentBirthDate +
                ", studentDepartment='" + studentDepartment + '\'' +
                ", studentMajority='" + studentMajority + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studentNative='" + studentNative + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentIdCard='" + studentIdCard + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentPolitical='" + studentPolitical + '\'' +
                ", studentProfile='" + studentProfile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(studentName, student.studentName) &&
                Objects.equals(studentPassword, student.studentPassword) && Objects.equals(studentAge, student.studentAge) &&
                Objects.equals(studentGender, student.studentGender) && Objects.equals(studentBirthDate, student.studentBirthDate) &&
                Objects.equals(studentDepartment, student.studentDepartment) && Objects.equals(studentMajority, student.studentMajority) &&
                Objects.equals(studentClass, student.studentClass) && Objects.equals(studentNative, student.studentNative) &&
                Objects.equals(studentAddress, student.studentAddress) && Objects.equals(studentIdCard, student.studentIdCard) &&
                Objects.equals(studentPhone, student.studentPhone) && Objects.equals(studentEmail, student.studentEmail) &&
                Objects.equals(studentPolitical, student.studentPolitical) && Objects.equals(studentProfile, student.studentProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, studentPassword, studentAge, studentGender, studentBirthDate,
                studentDepartment, studentMajority, studentClass, studentNative, studentAddress, studentIdCard,
                studentPhone, studentEmail, studentPolitical, studentProfile);
    }
}