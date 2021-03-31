package com.durong.student_info_manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class_info")
public class Classes {
    @Id
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "major_id")
    private Integer majorId;
    @Column(name = "department_id")
    private Integer departmentId;

    public Classes() {}

    public Classes(Integer classId, Integer majorId, Integer departmentId) {
        this.classId = classId;
        this.majorId = majorId;
        this.departmentId = departmentId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", majorId=" + majorId +
                ", departmentId=" + departmentId +
                '}';
    }
}
