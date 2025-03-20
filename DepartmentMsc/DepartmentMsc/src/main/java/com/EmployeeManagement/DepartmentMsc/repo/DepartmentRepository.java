package com.EmployeeManagement.DepartmentMsc.repo;

import com.EmployeeManagement.DepartmentMsc.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
