package com.example.Task.service;

import com.example.Task.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(Long student_id);

    Student updateStudent(Student student);
    void deleteStudent(Long student_id);
    Student assignCourseToStudent(Long studentId, Long courseId);
}
