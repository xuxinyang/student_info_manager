package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.domain.Course;
import com.durong.student_info_manager.domain.Grade;
import com.durong.student_info_manager.domain.Student;
import com.durong.student_info_manager.domain.Teacher;
import com.durong.student_info_manager.service.CourseService;
import com.durong.student_info_manager.service.GradeService;
import com.durong.student_info_manager.service.StudentService;
import com.durong.student_info_manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Student student = studentService.findById(studentId);
        List<Course> courses = new ArrayList<Course>();
        for (Grade grade : grades) {
            Course course = courseService.findById(grade.getCourseId());
            courses.add(course);
        }
        model.addAttribute("grades", grades);
        model.addAttribute("student", student);
        model.addAttribute("courses", courses);
        return "student/stuLookGrade";
    }
    // 教师端通过教师ID进行查找
    @RequestMapping(value = "/teacherLookGrade", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherLookGrade(Model model, String teacherId) {
        List<Course> courses = courseService.findAllCourseByTeacherId(teacherId);
        List<Grade> grades = new ArrayList<Grade>();
        for (Course c : courses) {
            grades.addAll(gradeService.findAllByCourseId(c.getCourseId()));
        }
        Teacher teacher = teacherService.findById(teacherId);
        model.addAttribute("teacher", teacher);
        model.addAttribute("grades", grades);
        return "teacher/teachGradeManager";
    }

    // 教师端通过教师ID进行查找并进行成绩的前端展示
    @RequestMapping(value = "/teacherGradeAnalysis", method = {RequestMethod.GET, RequestMethod.POST})
    public String teacherGradeAnalysis(Model model, String teacherId) {
        Map<Course, List<Grade>> gradeMap = new HashMap<>();
        List<Course> courses = courseService.findAllCourseByTeacherId(teacherId);
        List<Grade> grades = new ArrayList<Grade>();
        for (Course c : courses) {
            gradeMap.put(c, gradeService.findAllByCourseId(c.getCourseId()));
        }
        Teacher teacher = teacherService.findById(teacherId);
        model.addAttribute("teacher", teacher);
        model.addAttribute("grades", grades);
        model.addAttribute("gradeMap", gradeMap);
        return "teacher/teachGradeAnalysis";
    }

    // 查找操作 <-- end -->


}
