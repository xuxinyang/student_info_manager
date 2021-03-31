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

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginControl", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginControl(Model model, String roleId, String password) {

        System.out.println(roleId);
        if(roleService.findById(roleId) == null) {
            return "login";
        } else {
            if(roleService.findById(roleId).getRoleWeight() == 1) {
                Student student = studentService.findById(roleId);
//                if (shaEncrypt.validatePwd(password, student.getStudentPassword())) {
                if (student.getStudentPassword().equals(password)) {
                    model.addAttribute("student", student);
                    return "student/main";
                } else {
                    return "login";
                }
            }
            else if (roleService.findById(roleId).getRoleWeight() == 2) {
                Teacher teacher = teacherService.findById(roleId);
                if (shaEncrypt.validatePwd(password, teacher.getTeacherPassword())) {
                    model.addAttribute("teacher", teacher);
                    return "teacher/main";
                } else {
                    return "login";
                }
            } else {
                Admin admin = adminService.findId(roleId);
//                if (shaEncrypt.validatePwd(password, admin.getAdminPassword())) {
                    if (admin.getAdminPassword().equals(password)) {
                    model.addAttribute("admin", admin);
                    return "admin/main";
                } else {
                    return "login";
                }
            }
        }
    }

}
