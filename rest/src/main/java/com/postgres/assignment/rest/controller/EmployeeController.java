package com.postgres.assignment.rest.controller;

import com.postgres.assignment.rest.entity.Employee;
import com.postgres.assignment.rest.exception.RecordNotFoundException;
import com.postgres.assignment.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employee")
    public List<Employee> findAllEmployee() {
        return employeeService.getEmployee();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee findEmployeeById(@PathVariable("employeeId") Long employeeId) throws RecordNotFoundException {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/department")
    public List<String> findAllDepartment() {
        return employeeService.findAllDepartment();
    }
}