package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.domain.Teacher;
import com.durong.student_info_manager.service.RoleService;
import com.durong.student_info_manager.service.TeacherService;
import com.durong.student_info_manager.util.SHAEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    RoleService roleService;
    SHAEncrypt shaEncrypt = new SHAEncrypt();

    // 针对于教师表的操作，增加，删除，修改以及查询

    // 新增操作 <-- start -->
    @RequestMapping(value = "/teacherAdd", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherAdd(Model model, String teacherId, String teacherName, String teacherPassword,
                             Integer teacherAge, String teacherGender, Integer teacherDepartment,
                             String teacherNative, String teacherAddress, String teacherPhone,
                             String teacherEmail) {
        String encodePwd = shaEncrypt.encryptPwd(teacherPassword);
        roleService.create(teacherId, 1);
        teacherService.create(teacherId, teacherName, encodePwd, teacherAge, teacherGender,
                teacherDepartment, teacherNative, teacherAddress, teacherPhone, teacherEmail,
                null);
        model.addAttribute("teachers", teacherService.findAll());
        return "admin/teachManager";
    }
    // 新增操作 <-- end -->

    // 更新操作 <-- start -->
    // 更新全部信息
    @RequestMapping(value = "/teacherUpdate", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Teacher> teacherUpdate(@RequestBody Teacher teacher) {
        String encodePwd = shaEncrypt.encryptPwd(teacher.getTeacherPassword());
        teacherService.update(teacher.getTeacherId(), teacher.getTeacherName(), encodePwd,
                teacher.getTeacherAge(), teacher.getTeacherGender(), teacher.getTeacherDepartment(),
                teacher.getTeacherNative(), teacher.getTeacherAddress(), teacher.getTeacherPhone(),
                teacher.getTeacherEmail(), null);
        return teacherService.findAll();
    }
    // 只更新密码
    @RequestMapping(value = "/teacherUpdatePwd", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherUpdate1(Model model, String teacherId, String teacherPassword) {
        String encodePwd = shaEncrypt.encryptPwd(teacherPassword);
        teacherService.stuUpdate(teacherId, teacherPassword);
        Teacher teacher = teacherService.findById(teacherId);
        model.addAttribute("teacher", teacher);
        return "teacher/teachInfo";
    }
    // 更新操作 <-- end -->

    // 删除操作 <-- start -->
    // 根据教师 ID 进行删除
    @RequestMapping(value = "/teacherDeleteById", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherDeleteById(Model model, String teacherId) {
        roleService.delete(teacherId);
        teacherService.delete(teacherId);
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "admin/teachManager";
    }
    // 删除操作 <-- end -->
    // 查询操作 <-- start -->
    // 查询全部
    @RequestMapping(value = "/teacherAll", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherAll(Model model) {
        List<Teacher> teachers = teacherService.findAll();
        System.out.println(teachers.size());
        model.addAttribute("teachers", teachers);
        return "admin/teachManager";
    }
    // 管理员通过ID查询某一个教师
    @RequestMapping(value = "/teacherFindByIdFromAdmin", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherFindByIdFromAdmin(Model model, String teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        model.addAttribute("teacher", teacher);
        return "admin/teachManager";
    }
    // 教师端查看自己信息
    @RequestMapping(value = "/teacherFindByIdFromTeacher", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherFindByIdFromTeacher(Model model, String teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        model.addAttribute("teacher", teacher);
        return "teacher/teachInfo";
    }
    // 通过学院进行查询
    @RequestMapping(value = "/teacherFindByClassAndMajority", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherFindByClassAndMajority(Model model, Integer teacherDepartment) {
        List<Teacher> teachers = teacherService.findAllTeachersOfDepartment(teacherDepartment);
        model.addAttribute("teachers", teachers);
        return "admin/teachManager";
    }
    // 查询操作 <-- end -->
}