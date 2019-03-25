package com.collabera.jump.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.jump.helper.EmployeeHelper;
import com.collabera.jump.model.Department;
import com.collabera.jump.model.Employee;
import com.collabera.jump.model.Gender;

@RestController
@RequestMapping("/api")
public class MasterController {
	
	@GetMapping("/genders")
	public ResponseEntity<Gender[]> getGenders() {
		return ResponseEntity.ok(Gender.values());
	}
	
	@GetMapping("/departments")
	public ResponseEntity<Department[]> getDepartments() {
		return ResponseEntity.ok(Department.values());
	}
	
	@GetMapping("/employees")
	public ResponseEntity<HashMap<Integer, Employee>> getEmployees() {
		return ResponseEntity.ok(EmployeeHelper.getEmps());
	}
	
}
