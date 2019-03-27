package com.collabera.jump.controller;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

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

import com.collabera.jump.exceptions.ExceptionResponse;
import com.collabera.jump.model.Address;
import com.collabera.jump.model.Department;
import com.collabera.jump.model.Employee;
import com.collabera.jump.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	//----------------------------------------------GET-------------------------------------------------------------
	@ApiOperation(
			value = "get-employees", 
			notes = "This is to list all employees", 
			response = Employee.class
			)
	@ApiResponses({ @ApiResponse (code = 400, message="Employees Not Found", response = ExceptionResponse.class) })
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getEmployees() {
		
		List<Employee> emps = es.getEmployees();
		
		return ResponseEntity.ok(emps);
	}
	
	@ApiOperation(
			value = "get-employee-by-id", 
			notes = "This is to get a specific employee by ID", 
			response = Employee.class
			)
	@ApiResponses({ @ApiResponse (code = 400, message="Employee Not Found", response = ExceptionResponse.class) })
	@GetMapping("/id/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		
		Employee emp = es.getEmployeeById(id);
		
		return ResponseEntity.ok(emp);
	}
	
	@ApiOperation(
			value = "get-employee-by-name", 
			notes = "This is to get a specific employee by name", 
			response = Employee.class
			)
	@ApiResponses({ @ApiResponse (code = 400, message="Employee Not Found", response = ExceptionResponse.class) })
	@GetMapping("/name/{name}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {
		
		Employee emp = es.getEmployeeByName(name);
		
		return ResponseEntity.ok(emp);
	}
	
	@ApiOperation(
			value = "get-employee-by-streetAddress", 
			notes = "This is to get a specific employee by street address", 
			response = Employee.class
			)
	@ApiResponses({ @ApiResponse (code = 400, message="Employee Not Found", response = ExceptionResponse.class) })
	@GetMapping("/address/{streetAddress}")
	public ResponseEntity<Employee> getEmployeeByStreet(@PathVariable String streetAddress) {
		
		Employee emp = es.getEmployeeByStreet(streetAddress);
		
		return ResponseEntity.ok(emp);
	}
	
	@ApiOperation(
			value = "get-employee-by-dept", 
			notes = "This is to get all employees of a specific department", 
			response = Employee.class,
			responseContainer = "List"
			)
	@ApiResponses({ @ApiResponse (code = 400, message="Employees Not Found", response = ExceptionResponse.class) })
	@GetMapping("/dept/{dept}")
	public ResponseEntity<List<Employee>> getEmployeeByDept(@PathVariable Department dept){
		List<Employee> emps = es.getEmployeesByDept(dept);
		
		return ResponseEntity.ok(emps);
	}
	
	@ApiOperation(
			value = "get-address-by-employee-id", 
			notes = "This is to get a specific address by employee ID", 
			response = Address.class
			)
	@ApiResponses({ @ApiResponse (code = 400, message="Address Not Found", response = ExceptionResponse.class) })
	@GetMapping("/{id}/address")
	public ResponseEntity<Address> getAddress(@PathVariable Integer id) {
		
		Address a = es.getAddressByEmpId(id);
		
		return ResponseEntity.ok(a);
	}
	
	@ApiOperation(
			value = "get-phone-number-by-employee-id", 
			notes = "This is to get a specific phone number by employee ID", 
			response = BigInteger.class
			)
	@ApiResponses({ @ApiResponse (code = 400, message="Phone Number Not Found", response = ExceptionResponse.class) })
	@GetMapping("/{id}/phoneNumber")
	public ResponseEntity<BigInteger> getPhoneNumber(@PathVariable Integer id) {
		
		BigInteger pn = es.getPhoneNumberByEmployeeId(id);
		
		return ResponseEntity.ok(pn);
	}
	
	//---------------------------------------------POST--------------------------------------------------------------
	@ApiOperation(value = "create-employee", notes = "This is to add a new employee to the EMS")
	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody @Valid Employee emp) {
		
		if(es.createEmployee(emp)) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(emp.getEmpId()).toUri();
			return ResponseEntity.created(location).body(emp);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//----------------------------------------------PUT-------------------------------------------------------------
	@ApiOperation(value = "update-employee", notes = "This is to update a specific employee in the EMS")
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody @Valid Employee emp) {
		
		if(es.updateEmployee(emp.getEmpId(), emp)) {
			return ResponseEntity.ok().body(emp);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//---------------------------------------------DELETE------------------------------------------------------------
	@ApiOperation(value = "delete-employee", notes = "This is to delete a specific employee from the EMS")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		
		if(es.deleteEmployee(id)) {
			return ResponseEntity.ok("Employee Deleted");
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
