package com.durong.student_info_manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "major_info")
public class Major {
    @Id
    @Column(name = "majorId")
    private Integer majorId;
    @Column(name = "majorName")
    private String majorName;;
    @Column(name = "departmentId")
    private Integer departmentId;

    public Major() {

    }

    public Major(Integer majorId, String majorName, Integer departmentId) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.departmentId = departmentId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", majorName='" + majorName + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
