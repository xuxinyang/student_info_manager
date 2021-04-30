package com.durong.student_info_manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_info")
public class Course {

    @Id
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_status")
    private String courseStatus;
    @Column(name = "teacher_id")
    private String teacherId;
    public Course() {

    }

    public Course(Integer courseId, String courseName, String courseStatus, String teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseStatus = courseStatus;
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseStatus='" + courseStatus + '\'' +
                ", teacherId=" + teacherId + '\'' +
                '}';
    }
}
