package com.durong.student_info_manager.controller;

import com.durong.student_info_manager.domain.Record;
import com.durong.student_info_manager.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RecordController {

    @Autowired
    RecordService recordService;
    // 查询操作 <-- start -->
    // 查询全部
    @RequestMapping(value = "/recordAll", method = {RequestMethod.GET, RequestMethod.POST})
    public String recordAll(Model model) {
        List<Record> records = recordService.findAll();
        System.out.println(records.size());
        model.addAttribute("records", records);
        return "admin/stuManager";
    }
    // 管理员通过ID查询某一个学生
    @RequestMapping(value = "/recordFindByIdFromAdmin", method = {RequestMethod.GET, RequestMethod.POST})
    public String recordFindByIdFromAdmin(Model model, String recordId) {
        Record record = recordService.findById(recordId);
        model.addAttribute("record", record);
        return "admin/stuManager";
    }
    // 学生端查看自己信息
    @RequestMapping(value = "/recordFindByIdFromRecord", method = {RequestMethod.GET, RequestMethod.POST})
    public String recordFindByIdFromRecord(Model model, String recordId) {
        Record record = recordService.findById(recordId);
        model.addAttribute("record", record);
        return "record/stuInfo";
    }
    // 通过班级和专业进行查询
    @RequestMapping(value = "/recordFindByClassAndMajority", method = {RequestMethod.GET, RequestMethod.POST})
    public String recordFindByClassAndMajority(Model model, String recordClass, Integer recordMajority) {
        List<Record> records = recordService.findAllRecordsOfClassAndMajority(recordClass, recordMajority);
        model.addAttribute("records", records);
        return "admin/stuManager";
    }
    // 查询操作 <-- end -->
}
