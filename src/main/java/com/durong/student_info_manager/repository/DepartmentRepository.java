package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Serializable> {
    public List<Department> findByDepartmentId(Integer departmentId);
    public List<Department> findByDepartmentName(String departmentName);
}
