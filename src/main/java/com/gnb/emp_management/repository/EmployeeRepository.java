package com.gnb.emp_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gnb.emp_management.entity.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    // JPQL query: find employees by department name
    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(String deptName);

    // Native SQL query: top 5 highest paid employees
    @Query(value = "SELECT * FROM employee ORDER BY salary DESC LIMIT 5", nativeQuery = true)
    List<Employee> findTop5HighestPaid();
}
