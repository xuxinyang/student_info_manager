package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface ClassesRepository extends JpaRepository<Classes, Serializable> {
    public List<Classes> findByClassId(Integer classId);
    public List<Classes> findByDepartmentId(Integer departmentId);
    public List<Classes> findByMajorId(Integer majorId);
}
