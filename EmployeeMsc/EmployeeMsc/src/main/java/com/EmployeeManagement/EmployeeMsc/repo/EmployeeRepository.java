package com.EmployeeManagement.EmployeeMsc.repo;

import com.EmployeeManagement.EmployeeMsc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
