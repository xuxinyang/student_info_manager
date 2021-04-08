package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Serializable> {

    public List<Major> findByDepartmentId(Integer departmentId);
}
