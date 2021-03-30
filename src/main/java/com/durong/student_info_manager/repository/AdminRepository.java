package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;!

public interface AdminRepository extends JpaRepository<Admin, Integer> {
//    public Admin findByAdminId(Integer adminId);
}
