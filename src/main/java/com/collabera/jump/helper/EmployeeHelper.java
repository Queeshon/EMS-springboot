package com.collabera.jump.helper;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.collabera.jump.model.Address;
import com.collabera.jump.model.Department;
import com.collabera.jump.model.Employee;
import com.collabera.jump.model.Gender;

@Component
public class EmployeeHelper {

	private static HashMap<Integer, Employee> emps = null;
	
	static {
		setEmps(new HashMap<>());
		
		Address a1 = new Address(1, "1 One Street", "One", "NY", "USA", "14068");
		Address a2 = new Address(2, "2 Two Street", "Two", "NY", "USA", "24068");
		Address a3 = new Address(3, "3 Three Street", "Three", "NY", "USA", "34068");
		
		Employee emp = new Employee(
				"123456789", 
				1, 
				"Developer", 
				"christian.kim@collabera.com", 
				"Christian Kim", 
				23, 
				"7169390476", 
				100000, 
				true, 
				true, 
				Gender.MALE, 
				a1, 
				1, 
				Department.DEVELOPMENT
				);
		
		Employee emp2 = new Employee(
				"987654321", 
				2, 
				"Developer", 
				"shaan.shaikh@collabera.com", 
				"Shaan Shaikh", 
				23, 
				"7169373888", 
				200000, 
				true, 
				true, 
				Gender.MALE, 
				a2, 
				2, 
				Department.DEVELOPMENT
				);
		
		Employee emp3 = new Employee(
				"123454321", 
				3, 
				"Developer", 
				"chris.park@collabera.com", 
				"Chris Park", 
				23, 
				"7160987654", 
				300000, 
				true, 
				true, 
				Gender.MALE, 
				a3, 
				3, 
				Department.HR
				);
		
		getEmps().put(1, emp);
		getEmps().put(2, emp2);
		getEmps().put(3, emp3);
	}
	
	public Employee getEmployeeById(int id) {
		return getEmps().get(id);
	}
	
	public boolean createEmployee(Employee emp) {
		
		if(emp != null) {
			getEmps().put(emp.getEmpId(), emp);
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean updateEmployee(int id, Employee emp) {
		
		Employee update = getEmps().get(id);
		
		if(update != null && emp != null) {
			getEmps().put(update.getEmpId(), emp);
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean deleteEmployee(int id) {		
		if (getEmps() != null) {
			getEmps().remove(id);
		} else {
			return false;
		}
		
		return false;
	}

	public static HashMap<Integer, Employee> getEmps() {
		return emps;
	}

	public static void setEmps(HashMap<Integer, Employee> emps) {
		EmployeeHelper.emps = emps;
	}
	
}
