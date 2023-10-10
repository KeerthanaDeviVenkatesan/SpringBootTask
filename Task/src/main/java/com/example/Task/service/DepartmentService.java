package com.example.Task.service;

import com.example.Task.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(Long dep_id);
    Department updateDepartment(Department department);
    void deleteDepartment(Long dep_id);
}
