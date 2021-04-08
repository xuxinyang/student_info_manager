package com.durong.student_info_manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record_info")
public class Record {
    @Id
    @Column(name = "log_id")
    private Integer logId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "student_id")
    private String  studentId;

    public Record() {
    }

    public Record(Integer logId, Integer courseId, String studentId) {
        this.logId = logId;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
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
        return "Record{" +
                "logId=" + logId +
                ", courseId=" + courseId +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
