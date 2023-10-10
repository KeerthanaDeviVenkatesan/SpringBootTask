package com.example.Task.service.Impl;

import com.example.Task.repository.TeacherRepo;
import com.example.Task.entity.Teacher;
import com.example.Task.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(value = {"Local","Dev","Prod"})
public class TeacherServiceIml implements TeacherService {
    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher getTeacherById(Long teacher_id) {
        return teacherRepo.findById(teacher_id).orElse(null);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacher(Long teacher_id) {
        teacherRepo.deleteById(teacher_id);

    }
}
