package com.example.Task.service;

import com.example.Task.entity.Address;
import com.example.Task.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long course_id);
    Course updateCourse(Course course);
    void deleteCourse(Long course_id);
}
