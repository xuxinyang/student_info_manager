package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Admin;
import com.durong.student_info_manager.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public void create(String adminId, String adminName, String adminPassword) {
        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setAdminPassword(adminPassword);
        adminRepository.save(admin);
    }

    // update administrator password
    public void update(String adminId, String adminName, String adminPassword) {
        Admin admin = adminRepository.findById(adminId).orElse(null);
        if (admin != null) {
            admin.setAdminName(adminName);
            admin.setAdminPassword(adminPassword);
            adminRepository.save(admin);
        }
    }

    public Admin findById(String adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

}
