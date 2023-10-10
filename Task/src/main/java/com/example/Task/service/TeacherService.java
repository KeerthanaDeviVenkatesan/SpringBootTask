package com.example.Task.service;

import com.example.Task.entity.Student;
import com.example.Task.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);

    List<Teacher> getAllTeacher();

    Teacher getTeacherById(Long teacher_id);

    Teacher updateTeacher(Teacher teacher);
    void deleteTeacher(Long teacher_id);
}
