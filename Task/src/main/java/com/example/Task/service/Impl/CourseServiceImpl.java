package com.example.Task.service.Impl;

import com.example.Task.repository.CourseRepo;
import com.example.Task.entity.Course;
import com.example.Task.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(value = {"Local","Dev","Prod"})
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;
    @Override
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(Long course_id) {
        return courseRepo.findById(course_id).orElse(null);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void deleteCourse(Long course_id) {
        courseRepo.deleteById(course_id);
    }
}
