package com.gnb.emp_management.controller;

import com.gnb.emp_management.entity.Employee;
import com.gnb.emp_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ✅ Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // ✅ Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // ✅ Create new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // ✅ Update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    // ✅ Delete employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully!";
    }

    // ✅ Custom query: find employees by department name
    @GetMapping("/search")
    public List<Employee> findByDepartment(@RequestParam String deptName) {
        return employeeService.findByDepartmentName(deptName);
    }

    // ✅ Custom query: top 5 highest paid employees
    @GetMapping("/top5")
    public List<Employee> findTop5HighestPaid() {
        return employeeService.findTop5HighestPaid();
    }
}
