
package com.collabera.jump.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

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
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		
		ExceptionResponse response = new ExceptionResponse(e.getMessage(), errors.toString());
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ExceptionResponse> addressNotFoundException(AddressNotFoundException e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		
		ExceptionResponse response = new ExceptionResponse(e.getMessage(), errors.toString());
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(PhoneNumberNotFoundException.class)
	public ResponseEntity<ExceptionResponse> phoneNumberNotFoundException(PhoneNumberNotFoundException e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		
		ExceptionResponse response = new ExceptionResponse(e.getMessage(), errors.toString());
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> runtimeException(RuntimeException e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		
		ExceptionResponse response = new ExceptionResponse(e.getMessage(), errors.toString());
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionResponse> nullPointerException(NullPointerException e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		
		ExceptionResponse response = new ExceptionResponse(e.getMessage(), errors.toString());
		return ResponseEntity.badRequest().body(response);
	}
}