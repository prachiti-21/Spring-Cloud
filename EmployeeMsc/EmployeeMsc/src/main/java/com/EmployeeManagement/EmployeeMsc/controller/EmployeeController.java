package com.EmployeeManagement.EmployeeMsc.controller;

import com.EmployeeManagement.EmployeeMsc.model.Employee;
import com.EmployeeManagement.EmployeeMsc.repo.DepartmentClient;
import com.EmployeeManagement.EmployeeMsc.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")

class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentClient departmentClient;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/department")
    public String getEmployeeDepartment(@PathVariable int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return "Employee not found";
        }
        return departmentClient.getDepartmentById(employee.getDepartmentId());
    }
}
