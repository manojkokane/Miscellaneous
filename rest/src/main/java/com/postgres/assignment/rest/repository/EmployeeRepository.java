package com.postgres.assignment.rest.repository;

import com.postgres.assignment.rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeId(Long employeeId);

    @Query("SELECT DISTINCT departmentName FROM Employee")
    List<String> findDistinctDepartment();
}
