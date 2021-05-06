package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.domain.Admin;
import com.durong.student_info_manager.domain.Student;
import com.durong.student_info_manager.domain.Teacher;
import com.durong.student_info_manager.service.AdminService;
import com.durong.student_info_manager.service.RoleService;
import com.durong.student_info_manager.service.StudentService;
import com.durong.student_info_manager.service.TeacherService;
import com.durong.student_info_manager.util.SHAEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    RoleService roleService;
    SHAEncrypt shaEncrypt = new SHAEncrypt();
    // Admin Login Control
    @RequestMapping(value = "/adminLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public String adminLogin() {
        return "admin/login";
    }
    @RequestMapping(value = "/adminLoginControl", method = {RequestMethod.GET, RequestMethod.POST})
    public String adminLoginControl(Model model, String adminId, String adminPassword) {
        Admin admin = adminService.findById(adminId);
        if (admin == null) {
            return "admin/login";
        } else {
            if (admin.getAdminPassword().equals(adminPassword)) {
                model.addAttribute("admin", admin);
                return "admin/main";
            } else {
                return "admin/login";
            }
        }
    }
    // User Login Control
    @RequestMapping(value = "/userLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public String userLogin() {
        return "common/login";
    }
    @RequestMapping(value = "/userLoginControl", method = {RequestMethod.GET, RequestMethod.POST})
    public String userLoginControl(Model model, String roleId, String password) {
        System.out.println(roleId);
        if(roleService.findById(roleId) == null) {
            return "common/login";
        } else {
            if(roleService.findById(roleId).getRoleWeight() == 1) {
                Student student = studentService.findById(roleId);
                if (shaEncrypt.validatePwd(password, student.getStudentPassword())) {
                    model.addAttribute("student", student);
                    return "student/stuIndex";
                } else {
                    return "common/login";
                }
            }
            else if (roleService.findById(roleId).getRoleWeight() == 2) {
                Teacher teacher = teacherService.findById(roleId);
                if (shaEncrypt.validatePwd(password, teacher.getTeacherPassword())) {
//                if (teacher.getTeacherPassword().equals(password)) {
                    model.addAttribute("teacher", teacher);
                    return "teacher/teachIndex";
                } else {
                    return "common/login";
                }
            } else {
                return "common/login";
            }
        }
    }
}
