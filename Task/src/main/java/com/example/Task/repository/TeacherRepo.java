package com.example.Task.repository;

import com.example.Task.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
}
