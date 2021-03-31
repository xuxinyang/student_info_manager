package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Role;
import com.durong.student_info_manager.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    //  角色在新增的时候就给予权限，管理员只是有修改权限的能力
    public void create(String roleId, Integer roleWeight) {
        Role role = new Role();
        role.setRoleId(roleId);
        role.setRoleWeight(roleWeight);
        roleRepository.save(role);
    }

    public void update(String roleId, Integer roleWeight) {
        Role role = roleRepository.findRoleByRoleId(roleId);
        role.setRoleWeight(roleWeight);
        roleRepository.save(role);
    }
    // 不给角色删除权限
    public void delete(String roleId) {
        roleRepository.deleteByRoleId(roleId);
    }

    public List<Role> findAllByWeight(Integer roleWeight) {
        return new ArrayList<Role>(roleRepository.findRoleByRoleWeight(roleWeight));
    }

    public Role findById(String roleId) {
        return roleRepository.findRoleByRoleId(roleId);
    }

    public List<Role> findAll() {
        return new ArrayList<Role>(roleRepository.findAll());
    }
}