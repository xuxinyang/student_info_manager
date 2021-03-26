package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Serializable> {
    public List<Major> findByMajorId(Integer majorId);
    public List<Major> findByMajorName(String majorName);
}
