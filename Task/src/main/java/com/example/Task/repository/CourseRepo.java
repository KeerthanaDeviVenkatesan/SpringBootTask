package com.example.Task.repository;

import com.example.Task.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
