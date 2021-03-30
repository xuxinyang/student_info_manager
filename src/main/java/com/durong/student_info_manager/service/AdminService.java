package com.durong.student_info_manager.service;

import com.durong.student_info_manager.entity.Admin;
import com.durong.student_info_manager.repository.AdminRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {

    @Resource
    AdminRepository adminRepository;

    public void create(Integer adminId, String adminName, String adminPassword) {
        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setAdminPassword(adminPassword);
        adminRepository.save(admin);
    }

    public void delete(Integer adminId) {
        Admin admin = adminRepository.findById(adminId).get();
        adminRepository.delete(admin);
    }

    // update administrator password
    public void update(Integer adminId, String adminName, String adminPassword) {
        Admin admin = adminRepository.findById(adminId).get();
        admin.setAdminName(adminName);
        admin.setAdminPassword(adminPassword);
        adminRepository.save(admin);
    }

    // find admin
    public String findById(Integer adminId) {
        Admin admin = adminRepository.findById(adminId).get();
        return admin.getAdminPassword();
    }

    public Admin findId(Integer adminId) {
        return adminRepository.findById(adminId).get();
    }
}
