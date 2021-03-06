package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Department;
import com.durong.student_info_manager.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public void update(Integer departmentId, String departmentName) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department != null) {
            department.setDepartmentName(departmentName);
            departmentRepository.save(department);
        }
    }

    public Department findById(Integer departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
 }
