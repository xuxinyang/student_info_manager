package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.entity.Admin;
import com.durong.student_info_manager.service.AdminService;
import com.durong.student_info_manager.util.SHAEncrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
    AdminService adminService;
    SHAEncrypt shaEncrypt = new SHAEncrypt();

        @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "/loginControl", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginControl(Model model, String userId, String password) {

        System.out.println(userId);
        Integer uid = Integer.parseInt(userId);
        if (adminService.findById(uid) == null) {
            return "login";
        } else {
            Admin admin = adminService.findId(uid);
            if (shaEncrypt.validatePwd(password, admin.getAdminPassword())) {
                model.addAttribute("admin", admin);
                return "/admin/manager";
            } else {
                return "login";
            }
        }
    }

    @RequestMapping(value = "/admin", method = {RequestMethod.GET, RequestMethod.POST})
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "/manager")
    public String passwordValidate(Model model, String id, String password) {

        Admin admin;
        Integer adminId = Integer.parseInt(id);
        String pwd = adminService.findById(adminId);
        if (!password.equals(pwd)) {
            return "admin/login";
        } else {
            admin = adminService.findId(adminId);
            model.addAttribute("admin", admin);
            return "admin/manager";
        }
    }
}
