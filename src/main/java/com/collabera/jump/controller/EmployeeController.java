package com.collabera.jump.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.collabera.jump.helper.EmployeeHelper;
import com.collabera.jump.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeHelper helper;
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		
		Employee emp = helper.getEmployeeById(id);
		
		return ResponseEntity.ok(emp);
	}
	
	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody @Valid Employee emp) {
		
		if(helper.createEmployee(emp)) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(emp.getEmpId()).toUri();
			return ResponseEntity.created(location).body(emp);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody @Valid Employee emp) {
		
		if(helper.updateEmployee(id, emp)) {
			return ResponseEntity.ok().body(emp);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		
		if(helper.deleteEmployee(id)) {
			return ResponseEntity.ok("Employee Deleted");
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
