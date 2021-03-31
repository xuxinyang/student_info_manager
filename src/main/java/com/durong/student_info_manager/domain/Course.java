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

    public Course() {

    }

    public Course(Integer courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
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

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }

}