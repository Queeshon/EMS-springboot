package com.collabera.jump.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.jump.exceptions.AddressNotFoundException;
import com.collabera.jump.exceptions.EmployeeNotFoundException;
import com.collabera.jump.exceptions.PhoneNumberNotFoundException;
import com.collabera.jump.model.Address;
import com.collabera.jump.model.Employee;
import com.collabera.jump.repositories.AddressRepository;
import com.collabera.jump.repositories.EmployeeRepository;

@Service
public class EmployeeHelper {

	@Autowired
	private EmployeeRepository er;
	
	@Autowired
	private AddressRepository ar;
	
	//-----------------------------------------------GET------------------------------------------------------------
	public List<Employee> getEmployees() {
		List<Employee> emps = er.findAll();
		
		if(emps != null) {
			return emps;
		} else {
			throw new EmployeeNotFoundException("Employees Not Found");
		}
	}
	
	public Employee getEmployeeById(int id) {
		Employee emp = er.getOne(id);
		
		if(emp != null) {
			return emp;
		} else {
			throw new EmployeeNotFoundException("Employee with id: " + id + " Not Found");
		}
	}
	
	public Employee getEmployeeByName(String name) {
		Employee emp = er.findByName(name);
		
		if(emp != null) {
			return emp;
		} else {
			throw new EmployeeNotFoundException("Employee with name: " + name + " Not Found");
		}
	}
	
	public Employee getEmployeeByStreet(String streetAddress) {
		
		Employee emp = er.findByStreetOnAddress(streetAddress);
		
		if(emp != null) {
			return emp;
		} else {
			throw new EmployeeNotFoundException("Employee with address: " + streetAddress + " Not Found");
		}
	}
	
	public List<Employee> getEmployeeBySsn(String ssn) {
		List<Employee> emps = er.findBySsn(ssn);
		
		if(emps != null) {
			return emps;
		} else {
			throw new EmployeeNotFoundException("Employee with social security number: " + ssn + " Not Found");
		}
	}
	
	public Address getAddressByEmpId(int id) {
		Address add = er.getOne(id).getAddress();
		
		if(add != null) {
			return add;
		} else {
			throw new AddressNotFoundException("Address Not Found");
		}
	}
	
	public List<Address> getAddressesByStreet(String street) {
		List<Address> addresses = ar.findByStreetAddress(street);
		
		if (addresses != null) {
			return addresses;
		} else {
			throw new AddressNotFoundException("Addresses Not Found");
		}
	}
	
	public BigInteger getPhoneNumberByEmployeeId(Integer empId) {
		BigInteger pn = er.findPhoneNumberByEmployeeId(empId);
		
		if(pn != null) {
			return pn;
		} else {
			throw new PhoneNumberNotFoundException("Phone Number Not Found");
		}
	}
	
	//----------------------------------------------POST-------------------------------------------------------------
	public boolean createEmployee(Employee emp) {
		
		er.saveAndFlush(emp);
		return true;
		
	}
	
	//-----------------------------------------------PUT-------------------------------------------------------------
	public boolean updateEmployee(int id, Employee emp) {
		
		if(er.existsById(id) && emp != null) {
			createEmployee(emp);
			return true;
		} else {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		
	}
	
	public boolean updateAddress(int id, Address a) {
		Employee updateEmp = getEmployeeById(id);
		
		Address updateAddress = updateEmp.getAddress();
		
		if (updateAddress != null && a != null) {
			updateEmp.setAddress(a);
			return true;
		} else {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
	}
	
	//---------------------------------------------DELETE------------------------------------------------------------
	public boolean deleteEmployee(int id) {		
		if (er.existsById(id)) {
			er.deleteById(id);
			return true;
		} else {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
	}
	
}
