package com.example.Task.service.Impl;

import com.example.Task.repository.DepartmentRepo;
import com.example.Task.entity.Department;
import com.example.Task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile(value = {"Local","Dev","Prod"})
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;
    @Override
    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDepartmentById(Long dep_id) {
        return departmentRepo.findById(dep_id).orElse(null);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public void deleteDepartment(Long dep_id) {
        departmentRepo.deleteById(dep_id);
    }
}
