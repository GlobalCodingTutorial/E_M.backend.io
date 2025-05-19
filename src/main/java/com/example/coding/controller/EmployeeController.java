package com.example.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coding.model.Employee;
import com.example.coding.service.EmployeeService;

@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://management-emp.netlify.app/"
})
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private final EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@GetMapping
	public List<Employee> getAll(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id ,@RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteEmployee(id);
	}
}



























