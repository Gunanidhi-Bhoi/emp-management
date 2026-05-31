package com.gnb.emp_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gnb.emp_management.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
