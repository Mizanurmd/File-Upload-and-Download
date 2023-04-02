package com.Spring.file.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.file.model.Employee;
import com.Spring.file.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	////////////// Employee create method here//////////
	public Employee createEmployee(Employee employee) {
		return empRepository.save(employee);
	}
	
	///////////// get All employee method here ////////
	
	public List<Employee> getAllEmployees(){
		return empRepository.findAll();
	}

	/////////// Get single Employee method here ////////////
	public Optional<Employee> getSingleEmployee(Long id) {
		return empRepository.findById(id);
	}
	
	///////////// Delete Employee method here /////////////
	public void deleteEmployee(Long id) {
		empRepository.deleteById(id);
	}
	
	//////// Update Employee method here /////////////////
	
	
	
}
