package com.example.coding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coding.model.Employee;
import com.example.coding.repository.EmployeeRepository;
import com.example.coding.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private final EmployeeRepository repo;
	
	public EmployeeServiceImpl(EmployeeRepository repo) {
		this.repo = repo;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee existing = repo.findById(id).orElse(null);
		if(existing != null) {
			existing.setName(employee.getName());
			existing.setPhone( employee.getPhone());
			existing.setEmail(employee.getEmail());
			return repo.save(existing);
		}
		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
       repo.deleteById(id);		
	}

}
