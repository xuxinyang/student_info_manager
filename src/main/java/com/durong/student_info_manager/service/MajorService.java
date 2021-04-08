package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Major;
import com.durong.student_info_manager.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorService {
    @Autowired
    MajorRepository majorRepository;

    public void create(Integer majorId, String majorName, Integer departmentId) {
        Major major = new Major();
        major.setMajorId(majorId);
        major.setMajorName(majorName);
        major.setDepartmentId(departmentId);
        majorRepository.save(major);
    }

    public void update(Integer majorId, String majorName, Integer departmentId) {
        Major major = majorRepository.findById(majorId).orElse(null);
        if (major != null) {
            major.setMajorName(majorName);
            major.setDepartmentId(departmentId);
            majorRepository.save(major);
        }

    }

    public void delete(Integer majorId) {
        majorRepository.deleteById(majorId);
    }

    public List<Major> findAll() {
        List<Major> majors = new ArrayList<Major>();
        majorRepository.findAll().addAll(majors);
        return majors;
    }

    public List<Major> findAllByDepartmentId(Integer departmentId) {
        return new ArrayList<Major>(majorRepository.findByDepartmentId(departmentId));
    }

}
