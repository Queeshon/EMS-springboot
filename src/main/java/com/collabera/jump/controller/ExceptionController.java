
package com.collabera.jump.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.collabera.jump.exceptions.AddressNotFoundException;
import com.collabera.jump.exceptions.EmployeeNotFoundException;
import com.collabera.jump.exceptions.ExceptionResponse;
import com.collabera.jump.exceptions.PhoneNumberNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> employeeNotFoundException(EmployeeNotFoundException e) {
		ExceptionResponse response = new ExceptionResponse("ENF", "Employee was not present");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ExceptionResponse> addressNotFoundException(AddressNotFoundException e) {
		ExceptionResponse response = new ExceptionResponse("ANF", "Address was not present");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(PhoneNumberNotFoundException.class)
	public ResponseEntity<ExceptionResponse> phoneNumberNotFoundException(PhoneNumberNotFoundException e) {
		ExceptionResponse response = new ExceptionResponse("PNNF", "Phone number was not present");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> runtimeException(RuntimeException e) {
		ExceptionResponse response = new ExceptionResponse("Runtime", "Runtime Exception present");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionResponse> nullPointerException(NullPointerException e) {
		ExceptionResponse response = new ExceptionResponse("Null", "Null was not present");
		
		return ResponseEntity.badRequest().body(response);
	}
}