package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.domain.Course;
import com.durong.student_info_manager.domain.Student;
import com.durong.student_info_manager.domain.Teacher;
import com.durong.student_info_manager.service.AdminService;
import com.durong.student_info_manager.service.CourseService;
import com.durong.student_info_manager.service.StudentService;
import com.durong.student_info_manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    AdminService adminService;
    @Autowired
    CourseService courseService;

    // 新增课程 <-- start -->
    @RequestMapping(value = "/addCourse", method = {RequestMethod.GET, RequestMethod.POST})
    public String addCourse(Model model, String courseId, String courseName, String courseStatus, String teacherId) {
        Integer integerCourseId = Integer.valueOf(courseId);
        courseService.create(integerCourseId, courseName, courseStatus, teacherId);
        return getString(model);
    }

    private String getString(Model model) {
        List<Course> courses = courseService.findAll();
        List<Teacher> teachers = new ArrayList<Teacher>();
        for (Course cour : courses) {
            teachers.add(teacherService.findById(cour.getTeacherId()));
        }
        model.addAttribute("courses", courses);
        model.addAttribute("teachers", teachers);
        return "admin/courseManager";
    }
    // 新增课程 <-- end -->

    // 删除课程
    @RequestMapping(value = "/deleteByCourseId", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteByCourseId(Model model, String courseId) {
        courseService.deleteByCourseId(Integer.parseInt(courseId));
        return getString(model);
    }
    // 更新课程 <-- start -->
    @RequestMapping(value = "/updateCourse", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<Course> updateCourse(@RequestBody Course course) {
        courseService.update(course.getCourseId(), course.getCourseName(), course.getCourseStatus(),
                course.getTeacherId());
        return courseService.findAll();
    }
    // 更新课程 <-- end -->
    // 查找操作 <-- start -->
    // 查找当前所有课程
    @RequestMapping(value = "/findAllCourse", method = {RequestMethod.GET, RequestMethod.POST})
    public String findAllCourse(Model model) {
        return getString(model);
    }
    // 通过教师Id进行查找
    @RequestMapping(value = "/findByTeacherId", method = {RequestMethod.GET, RequestMethod.POST})
    public String findByTeacherId(Model model, String teacherId) {
        List<Course> courses = courseService.findAllCourseByTeacherId(teacherId);
        Teacher teacher = teacherService.findById(teacherId);
        model.addAttribute("courses", courses);
        model.addAttribute("teacher", teacher);
        return "admin/courseManager";
    }
    // 通过课程状态进行查找
    @RequestMapping(value = "/findByCourseStatus", method = {RequestMethod.GET, RequestMethod.POST})
    public String findByCourseStatus(Model model, String courseStatus) {
        List<Course> courses = courseService.findAllCourseByStatus(courseStatus);
        model.addAttribute("courses", courses);
        return "admin/courseManager";
    }
    // 学生进行选课，先通过课程状态查找有哪些选修课
    @RequestMapping(value = "/studentChooseCourse", method = {RequestMethod.GET, RequestMethod.POST})
    public String studentChooseCourse(Model model, String studentId) {
        String courseStatus = "选修";
        List<Course> courses = courseService.findAllCourseByStatus(courseStatus);
        Student student = studentService.findById(studentId);
        model.addAttribute("courses", courses);
        model.addAttribute("student", student);
        return "student/stuChooseCourse";
    }
    // 查找操作 <-- end -->

}
