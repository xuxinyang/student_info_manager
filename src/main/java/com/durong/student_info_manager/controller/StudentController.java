package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.domain.Major;
import com.durong.student_info_manager.domain.Student;
import com.durong.student_info_manager.service.MajorService;
import com.durong.student_info_manager.service.RoleService;
import com.durong.student_info_manager.service.StudentService;
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
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    MajorService majorService;
    @Autowired
    RoleService roleService;
    SHAEncrypt shaEncrypt = new SHAEncrypt();

    // 针对于学生表的操作，增加，删除，修改以及查询

    // 新增操作 <-- start -->
    @RequestMapping(value = "/studentAdd", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentAdd(Model model, String studentId, String studentName, String studentPassword,
                             Integer studentAge, String studentGender, Integer studentMajority,
                             String studentClass, String studentNative, String studentAddress,
                             String studentIdCard, String studentPhone, String studentEmail) {
        String encodePwd = shaEncrypt.encryptPwd(studentPassword);
        roleService.create(studentId, 1);
        studentService.create(studentId, studentName, encodePwd, studentAge, studentGender,
                studentMajority, studentClass, studentNative, studentAddress,
                studentIdCard, studentPhone, studentEmail, null);
        model.addAttribute("students", studentService.findAll());
        return "admin/stuManager";
    }
    // 新增操作 <-- end -->

    // 更新操作 <-- start -->
    // 更新全部信息
    @RequestMapping(value = "/studentUpdate", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Student> studentUpdate(@RequestBody Student student) {
        String encodePwd = shaEncrypt.encryptPwd(student.getStudentPassword());
//        roleService.create(studentId, 1);
        studentService.update(student.getStudentId(), student.getStudentName(), encodePwd,
                student.getStudentAge(), student.getStudentGender(), student.getStudentMajority(),
                student.getStudentClass(), student.getStudentNative(), student.getStudentAddress(),
                student.getStudentIdCard(), student.getStudentPhone(), student.getStudentEmail(), null);
        return studentService.findAll();
    }

    // 只更新密码
    @RequestMapping(value = "/studentUpdatePwd", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentUpdatePwd(Model model, String studentId) {
        Student student = studentService.findById(studentId);
        model.addAttribute("student", student);
        return "student/stuUpdatePwd";
    }

    @RequestMapping(value = "/studentUpdatePwdOp", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentUpdatePwdOp(Model model, String studentId, String studentPassword) {
        String encodePwd = shaEncrypt.encryptPwd(studentPassword);
        studentService.stuUpdate(studentId, encodePwd);
        Student student = studentService.findById(studentId);
        model.addAttribute("student", student);
        return "common/login";
    }
    // 更新操作 <-- end -->

    // 删除操作 <-- start -->
    // 根据学生 ID 进行删除
    @RequestMapping(value = "/studentDeleteById", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentDeleteById(Model model, String studentId) {
        roleService.delete(studentId);
        studentService.delete(studentId);
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "admin/stuManager";
    }

    // 删除操作 <-- end -->
    // 查询操作 <-- start -->
    // 查询全部
    @RequestMapping(value = "/studentAll", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentAll(Model model) {
        List<Student> students = studentService.findAll();
        System.out.println(students.size());
        model.addAttribute("students", students);
        return "admin/stuManager";
    }

    // 管理员通过ID查询某一个学生
    @RequestMapping(value = "/studentFindByIdFromAdmin", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentFindByIdFromAdmin(Model model, String studentId) {
        Student student = studentService.findById(studentId);
        Major major = majorService.findById(student.getStudentMajority());
        model.addAttribute("student", student);
        model.addAttribute("major", major);
        return "admin/stuManager";
    }

    // 学生端查看自己信息
    @RequestMapping(value = "/studentFindByIdFromStudent", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentFindByIdFromStudent(Model model, String studentId) {
        Student student = studentService.findById(studentId);
        Major major = majorService.findById(student.getStudentMajority());
        model.addAttribute("student", student);
        model.addAttribute("major", major);
        return "student/stuInfo";
    }

    // 通过班级和专业进行查询
    @RequestMapping(value = "/studentFindByClassAndMajority", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentFindByClassAndMajority(Model model, String studentClass, Integer studentMajority) {
        List<Student> students = studentService.findAllStudentsOfClassAndMajority(studentClass, studentMajority);
        model.addAttribute("students", students);
        return "admin/stuManager";
    }
    // 查询操作 <-- end -->

}
