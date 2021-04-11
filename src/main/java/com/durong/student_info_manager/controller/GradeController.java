package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.domain.Grade;
import com.durong.student_info_manager.service.CourseService;
import com.durong.student_info_manager.service.GradeService;
import com.durong.student_info_manager.service.StudentService;
import com.durong.student_info_manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GradeController {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;
    @Autowired
    GradeService gradeService;

    // 新增成绩 <-- start -->
    @RequestMapping(value = "/createGrade", method = {RequestMethod.GET, RequestMethod.POST})
    public String createGrade(Model model, String gradeScore, String courseId, String studentId) {
        Float floatGradeScore = Float.valueOf(gradeScore);
        Integer integerCourseId = Integer.valueOf(courseId);
        gradeService.create(floatGradeScore, integerCourseId, studentId);
        model.addAttribute("students", studentService.findAll());
        return "teacher/teachGradeManager";
    }
    // 新增成绩 <-- end -->

    // 更新成绩 <-- start -->
    @RequestMapping(value = "/updateGrade", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateGrade(Model model, String gradeScore, String courseId, String studentId) {
        Float floatGradeScore = Float.valueOf(gradeScore);
        Integer integerCourseId = Integer.valueOf(courseId);
        gradeService.update(floatGradeScore, integerCourseId, studentId);
        model.addAttribute("students", studentService.findAll());
        return "teacher/teachGradeManager";
    }
    // 更新成绩 <-- end -->

    // 查找操作 <-- start -->
    // 学生端通过学生ID进行查找
    @RequestMapping(value = "/studentLookGrade", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentLookGrade(Model model, String studentId) {
        List<Grade> grades = gradeService.findAllByStudentId(studentId);
        model.addAttribute("grades", grades);
        return "student/stuLookGrade";
    }
    // 教师端通过课程ID进行查找
    @RequestMapping(value = "/teacherLookGrade", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherLookGrade(Model model, String courseId) {
        List<Grade> grades = gradeService.findAllByStudentId(courseId);
        model.addAttribute("grades", grades);
        return "teacher/teachGradeManager";
    }

    // 查找操作 <-- end -->


}
