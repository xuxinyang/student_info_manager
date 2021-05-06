package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.domain.Course;
import com.durong.student_info_manager.domain.Record;
import com.durong.student_info_manager.service.CourseService;
import com.durong.student_info_manager.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecordController {

    @Autowired
    RecordService recordService;
    @Autowired
    CourseService courseService;
    // 查询操作 <-- start -->
    // 查询全部
    @RequestMapping(value = "/recordAll", method = {RequestMethod.GET, RequestMethod.POST})
    public String recordAll(Model model) {
        List<Record> records = recordService.findAll();
        model.addAttribute("records", records);
        return "admin/courseManager";
    }
    // 管理员通过courseId查询选这个课程的所有学生
    @RequestMapping(value = "/recordFindByCourseId", method = {RequestMethod.GET, RequestMethod.POST})
    public String recordFindByIdFromAdmin(Model model, Integer courseId) {
        List<Record> records = recordService.findAllByCourseId(courseId);
        model.addAttribute("records", records);
        return "admin/courseManager";
    }
    // 管理员通过studentId查询该学生选择了哪些课程
    @RequestMapping(value = "/recordFindByIdFromRecord", method = {RequestMethod.GET, RequestMethod.POST})
    public String recordFindByIdFromRecord(Model model, String studentId) {
        List<Record> records = recordService.findAllByStudentId(studentId);
        model.addAttribute("records", records);
        return "admin/courseManager";
    }
    // 通过课程和学生编号进行查询
    @RequestMapping(value = "/recordFindByClassAndMajority", method = {RequestMethod.GET, RequestMethod.POST})
    public String recordFindByClassAndMajority(Model model, Integer courseId, String studentId) {
        Record record = recordService.findByCourseIdAndStudentId(courseId, studentId);
        model.addAttribute("record", record);
        return "admin/courseManager";
    }
    // 学生查找已经选择了哪些课程
    @RequestMapping(value = "/findAllChoiceCourse", method = {RequestMethod.GET, RequestMethod.POST})
    public String findAllChoiceCourse(Model model, String studentId)
    {
        List<Record> records = recordService.findAllByStudentId(studentId);
        List<Course> courses = new ArrayList<Course>();
        for (Record record : records)
        {
            courses.add(courseService.findById(record.getCourseId()));
        }
        model.addAttribute("records", records);
        model.addAttribute("courses", courses);
        return "student/stuChooseCourse";
    }
    // 查询操作 <-- end -->
}
