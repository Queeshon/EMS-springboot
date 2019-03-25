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
import com.collabera.jump.model.Address;

@RestController
@RequestMapping("/employee")
public class AddressController {

	@Autowired
	private EmployeeHelper helper;
	
	@GetMapping("/{empId}/address")
	public ResponseEntity<Address> getAddress(@PathVariable Integer id) {
		
		Address a = helper.getAddressByEmpId(id);
		
		return ResponseEntity.ok(a);
	}
	
	@PutMapping("/{empId}/address")
	public ResponseEntity<?> updateAddress(@PathVariable int id, @RequestBody @Valid Address a) {
		
		if(helper.updateAddress(id, a)) {
			return ResponseEntity.created(null).body(a);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
