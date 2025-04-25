package com.example.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coding.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
