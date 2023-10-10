package com.example.Task.controller;

import com.example.Task.entity.Department;
import com.example.Task.service.Impl.DepartmentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final Logger logger = LogManager.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentServiceImpl departmentService;


    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        logger.info("Received request to add a new Department: {}", department);
        Department addedDepartment = departmentService.createDepartment(department);
        logger.info("Added new department with ID: {}", addedDepartment.getDep_id());
        return addedDepartment;
    }


    @GetMapping("/departmentById/{dep_id}")
    public Department getDepartmentById(@PathVariable Long dep_id) {
        logger.info("Received request to get department by ID: {}", dep_id);
        Department department = departmentService.getDepartmentById(dep_id);
        logger.info("Returned department by ID: {}", department);
        return department;
    }

    @GetMapping("/allDepartments")
    public List<Department> getAllDepartment() {
        logger.info("Received request to get all department.");
        List<Department> departments = departmentService.getAllDepartment();
        logger.info("Returned {} departments.", departments.size());
        return departments;
    }

    @PutMapping("/{dep_id}")
    public Department updateDepartment(@PathVariable Long dep_id, @RequestBody Department department) {
        logger.info("Received request to update Department with ID: {}", dep_id);
        department.setDep_id(dep_id);
        Department updatedDepartment = departmentService.updateDepartment(department);
        logger.info("Updated department with ID: {}", dep_id);
        return updatedDepartment;
    }

    @DeleteMapping("/{dep_id}")
    public void deleteDepartment(@PathVariable Long dep_id) {
        logger.info("Received request to delete department with ID: {}", dep_id);
        departmentService.deleteDepartment(dep_id);
        logger.info("Deleted Department with ID: {}", dep_id);
    }
}

