package com.example.Task.repository;

import com.example.Task.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
}
