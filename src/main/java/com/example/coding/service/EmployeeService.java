package com.example.coding.service;

import java.util.List;

import com.example.coding.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Long id, Employee employee);
	void deleteEmployee(Long id);
}
