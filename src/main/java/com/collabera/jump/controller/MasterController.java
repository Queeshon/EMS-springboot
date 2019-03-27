package com.collabera.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.jump.model.Department;
import com.collabera.jump.model.Employee;
import com.collabera.jump.model.Gender;
import com.collabera.jump.repositories.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class MasterController {
	
	@Autowired
	private EmployeeRepository er;
	
	@GetMapping("/genders")
	public ResponseEntity<Gender[]> getGenders() {
		return ResponseEntity.ok(Gender.values());
	}
	
	@GetMapping("/departments")
	public ResponseEntity<Department[]> getDepartments() {
		return ResponseEntity.ok(Department.values());
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok(er.findAll());
	}
	
}
