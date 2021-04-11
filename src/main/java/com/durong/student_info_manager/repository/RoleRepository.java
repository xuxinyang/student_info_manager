package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Serializable> {

    public Role findRoleByRoleId(String roleId);

    public List<Role> findRoleByRoleWeight(Integer weight);

    @Modifying
    @Transactional
    public void deleteByRoleId(String roleId);
}