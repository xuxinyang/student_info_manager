package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.domain.Course;
import com.durong.student_info_manager.domain.Teacher;
import com.durong.student_info_manager.service.CourseService;
import com.durong.student_info_manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    // 新增课程 <-- start -->
    @RequestMapping(value = "/addCourse", method = {RequestMethod.GET, RequestMethod.POST})
    public String addCourse(Model model, String courseId, String courseName, String courseStatus, String teacherId) {
        Integer integerCourseId = Integer.valueOf(courseId);
        courseService.create(integerCourseId, courseName, courseStatus, teacherId);
        model.addAttribute("courses", courseService.findAll());
        return "admin/courseManager";
    }
    // 新增课程 <-- end -->

    // 更新课程 <-- start -->
    @RequestMapping(value = "/updateCourse", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateCourse(Model model, String courseId, String courseName, String courseStatus, String teacherId) {
        Integer integerCourseId = Integer.valueOf(courseId);
        courseService.update(integerCourseId, courseName, courseStatus, teacherId);
        model.addAttribute("courses", courseService.findAll());
        return "admin/courseManager";
    }
    // 更新课程 <-- end -->

    // 查找操作 <-- start -->
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
    // 查找操作 <-- end -->

}
