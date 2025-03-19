package com.EmployeeManagement.EmployeeMsc.repo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentClient {
    @GetMapping("/departments/{id}")
    String getDepartmentById(@PathVariable("id") int id);
}


