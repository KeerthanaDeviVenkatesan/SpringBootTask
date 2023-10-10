package com.example.Task.controller;

import com.example.Task.entity.Course;
import com.example.Task.service.Impl.CourseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private static final Logger logger = LogManager.getLogger(CourseController.class);

   @Autowired
   CourseServiceImpl courseServiceIml;

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        logger.info("Received request to add a new Course: {}", course);
        Course addedCourses = courseServiceIml.createCourse(course);
        logger.info("Added new Course with ID: {}", addedCourses.getCourse_id());
        return addedCourses;
    }


    @GetMapping("/courseById/{course_id}")
    public Course getCourseById(@PathVariable Long course_id) {
        logger.info("Received request to get course by ID: {}", course_id);
        Course course = courseServiceIml.getCourseById(course_id);
        logger.info("Returned course by ID: {}", course);
        return course;
    }

    @GetMapping("/allCourses")
    public List<Course> getAllCourses() {
        logger.info("Received request to get all course.");
        List<Course> courses = courseServiceIml.getAllCourses();
        logger.info("Returned {} courses.", courses.size());
        return courses;
    }

    @PutMapping("/{course_id}")
    public Course updateCourse(@PathVariable Long course_id, @RequestBody Course course) {
        logger.info("Received request to update Course with ID: {}", course_id);
        course.setCourse_id(course_id);
        Course updatedCourse = courseServiceIml.updateCourse(course);
        logger.info("Updated course with ID: {}", course_id);
        return updatedCourse;
    }

    @DeleteMapping("/{course_id}")
    public void deleteCourse(@PathVariable Long course_id) {
        logger.info("Received request to delete course with ID: {}", course_id);
        courseServiceIml.deleteCourse(course_id);
        logger.info("Deleted Course with ID: {}", course_id);
    }
}
