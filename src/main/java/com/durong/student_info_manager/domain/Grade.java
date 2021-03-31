package com.durong.student_info_manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grade_info")
public class Grade {
    @Id
    @Column(name = "grade_id")
    private Integer gradeId;
    @Column(name = "grade_score")
    private Float gradeScore;
    @Column(name = "course_id")
    private String courseId;
    @Column(name = "student_id")
    private String studentId;

    public Grade() {
    }

    public Grade(Integer gradeId, Float gradeScore, String courseId, String studentId) {
        this.gradeId = gradeId;
        this.gradeScore = gradeScore;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Float getGradeScore() {
        return gradeScore;
    }

    public void setGradeScore(Float gradeScore) {
        this.gradeScore = gradeScore;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gradeScore=" + gradeScore +
                ", courseId='" + courseId + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}

