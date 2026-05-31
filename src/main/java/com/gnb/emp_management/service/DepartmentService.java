package com.gnb.emp_management.service;

import com.gnb.emp_management.entity.Department;
import com.gnb.emp_management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }
}
