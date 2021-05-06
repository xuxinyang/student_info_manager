package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Course;
import com.durong.student_info_manager.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public void create(Integer courseId, String courseName, String courseStatus, String teacherId) {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setCourseStatus(courseStatus);
        course.setTeacherId(teacherId);
        courseRepository.save(course);
    }

    public void update(Integer courseId, String courseName, String courseStatus, String teacherId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            course.setCourseName(courseName);
            course.setCourseStatus(courseStatus);
            course.setTeacherId(teacherId);
            courseRepository.save(course);
        }
    }

    public void delete(Integer courseId) {
        courseRepository.deleteById(courseId);
    }

    public Course findById(Integer courseId)
    {
        return courseRepository.findById(courseId).orElse(null);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public List<Course> findAllCourseByStatus(String courseStatus)
    {
        return courseRepository.findByCourseStatus(courseStatus);
    }

    public List<Course> findAllCourseByTeacherId(String teacherId)
    {
        return  courseRepository.findByTeacherId(teacherId);
    }

    public void deleteByCourseId(Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}
