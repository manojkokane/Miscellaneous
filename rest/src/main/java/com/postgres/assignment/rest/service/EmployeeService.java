package com.postgres.assignment.rest.service;

import com.postgres.assignment.rest.entity.Employee;
import com.postgres.assignment.rest.exception.RecordNotFoundException;
import com.postgres.assignment.rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) throws RecordNotFoundException {
        Employee employee =  employeeRepository.findByEmployeeId(employeeId);
        if(employee==null) {
            String errorMessage = String.format("Employee with id %s does not exist. Please try another id.", employeeId);
            throw new RecordNotFoundException(errorMessage);
        }

        return employee;
    }

    public List<String> findAllDepartment() {
        return employeeRepository.findDistinctDepartment();
    }
}
