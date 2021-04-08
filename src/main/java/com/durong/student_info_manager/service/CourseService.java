package com.durong.student_info_manager.service;

import com.durong.student_info_manager.domain.Course;
import com.durong.student_info_manager.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    CourseRepository courseRepository;

    public void create(Integer courseId, String courseName, String courseStatus) {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setCourseStatus(courseStatus);
        courseRepository.save(course);
    }

    public void update(Integer courseId, String courseName, String courseStatus) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            course.setCourseName(courseName);
            course.setCourseStatus(courseStatus);
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
        List<Course> courses = new ArrayList<Course>();
        courseRepository.findAll().addAll(courses);
        return courses;
    }

    public List<Course> findAllCourseByStatus(String courseStatus)
    {
        return new ArrayList<Course>(courseRepository.findByCourseStatus(courseStatus));
    }
}
