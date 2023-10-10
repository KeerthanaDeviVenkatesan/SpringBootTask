package com.example.Task.service.Impl;

import com.example.Task.repository.CourseRepo;
import com.example.Task.repository.StudentRepo;
import com.example.Task.entity.Course;
import com.example.Task.entity.Student;
import com.example.Task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile(value = {"Local","Dev","Prod"})
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;
    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long student_id) {
        return studentRepo.findById(student_id).orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
    }

    @Override
    public Student assignCourseToStudent(Long studentId, Long courseId) {
        Set<Course> courseSet=null;
        Student student=studentRepo.findById(studentId).get();
        Course course=courseRepo.findById(courseId).get();
        courseSet=student.getAssignedCourses();
        courseSet.add(course);
        student.setAssignedCourses(courseSet);
        return studentRepo.save(student);

    }
}
