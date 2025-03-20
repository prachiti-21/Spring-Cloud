package com.EmployeeManagement.DepartmentMsc.controller;

import com.EmployeeManagement.DepartmentMsc.model.Department;
import com.EmployeeManagement.DepartmentMsc.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public String getDepartmentById(@PathVariable int id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return department != null ? department.getName() : "Department not found";
    }
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentRepository.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody Department updatedDepartment) {
        return departmentRepository.findById(id)
                .map(department -> {
                    department.setName(updatedDepartment.getName());
                    Department saved = departmentRepository.save(department);
                    return ResponseEntity.ok(saved);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
