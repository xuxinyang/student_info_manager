package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    public Admin findByAdminId(String adminId);
}
