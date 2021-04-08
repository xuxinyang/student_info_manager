package com.durong.student_info_manager.repository;

import com.durong.student_info_manager.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Serializable> {

    public List<Record> findByCourseId(Integer courseId);

    public List<Record> findByStudentId(String studentId);

    public Record findByCourseIdAndStudentId(Integer courseId, String studentId);

}
