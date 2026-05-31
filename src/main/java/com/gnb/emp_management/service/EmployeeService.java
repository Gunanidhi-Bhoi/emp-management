package com.gnb.emp_management.service;

import com.gnb.emp_management.entity.Employee;
import com.gnb.emp_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ✅ Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ✅ Get employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // ✅ Create new employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // ✅ Update employee
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(employee.getName());
            existing.setSalary(employee.getSalary());
            existing.setDepartment(employee.getDepartment());
            return employeeRepository.save(existing);
        }
        return null;
    }

    // ✅ Delete employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // ✅ Custom query: find employees by department name (JPQL)
    public List<Employee> findByDepartmentName(String deptName) {
        return employeeRepository.findByDepartmentName(deptName);
    }

    // ✅ Custom query: top 5 highest paid employees (Native SQL)
    public List<Employee> findTop5HighestPaid() {
        return employeeRepository.findTop5HighestPaid();
    }
}
