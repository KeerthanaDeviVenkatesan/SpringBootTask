package com.example.Task.controller;

import com.example.Task.entity.Student;
import com.example.Task.service.Impl.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {
    private static final Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    private StudentServiceImpl studentService;


    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        logger.info("Received request to add a new Student: {}", student);
        Student addedStudent = studentService.saveStudent(student);
        logger.info("Added new student with ID: {}", addedStudent.getStudent_id());
        return addedStudent;
    }


    @GetMapping("/studentById/{student_id}")
    public Student getStudentById(@PathVariable Long student_id) {
        logger.info("Received request to get student by ID: {}", student_id);
        Student student = studentService.getStudentById(student_id);
        logger.info("Returned student by ID: {}", student);
        return student;
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudent() {
        logger.info("Received request to get all students.");
        List<Student> students = studentService.getAllStudent();
        logger.info("Returned {} student.", students.size());
        return students;
    }

    @PutMapping("/{student_id}")
    public Student updateStudent(@PathVariable Long student_id, @RequestBody Student student) {
        logger.info("Received request to update student with ID: {}", student_id);
        student.setStudent_id(student_id);
        Student updatedStudent = studentService.updateStudent(student);
        logger.info("Updated student with ID: {}", student_id);
        return updatedStudent;
    }

    @DeleteMapping("/{student_id}")
    public void deleteStudent(@PathVariable Long student_id) {
        logger.info("Received request to delete student with ID: {}", student_id);
        studentService.deleteStudent(student_id);
        logger.info("Deleted student with ID: {}", student_id);
    }
    @PutMapping("/{student_id}/courses/{course_id}")
    public Student assignCourseToStudent(@PathVariable Long student_id,@PathVariable Long course_id){
        return studentService.assignCourseToStudent(student_id,course_id);
    }
}
