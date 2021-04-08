package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Record;
import com.durong.student_info_manager.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RecordService {
    @Autowired
    RecordRepository recordRepository;

    //  记录只进行新增和查找，不会进行删除
    public void create(Integer logId, Integer courseId, String studentId) {
        Record record = new Record();
        record.setCourseId(courseId);
        record.setStudentId(studentId);
        recordRepository.save(record);
    }

    public List<Record> findAllByCourseId(Integer courseId) {
        return new ArrayList<Record>(recordRepository.findByCourseId(courseId));
    }

    public Record findByCourseIdAndStudentId(Integer courseId, String studentId) {
        return recordRepository.findByCourseIdAndStudentId(courseId, studentId);
    }

    public List<Record> findAllByStudentId(String studentId) {
        return new ArrayList<Record>(recordRepository.findByStudentId(studentId));
    }
}
