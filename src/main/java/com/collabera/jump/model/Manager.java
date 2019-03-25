/**
 * 
 */
package com.collabera.jump.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Manager extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer, Employee> team = new HashMap<Integer, Employee>();

	public Manager(String ssn, int emp_id, String jobTitle, String email, String name, int age, String phoneNumber, long salary, boolean isManager, boolean active, Gender gender, Address address, int managerID, Department dept) {
		super(ssn, emp_id, jobTitle, email, name, age, phoneNumber, salary, isManager, active, gender, address, managerID, dept);
	}

	public Map<Integer, Employee> getTeam() {
		return team;
	}

	public void setTeam(Map<Integer, Employee> team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "(*)ManagerId = " + getEmpId() + " <===> Name = " + getName() + ", Age = " + getAge() + ", Gender = "
				+ getGender() + ", ContactNo = " + getPhoneNumber() + ",\n                       Address = "
				+ getAddress() + ",\n                       SSN = " + getSsn() + ", eMail = " + getEmail()
				+ ", Job Title = " + getJobTitle() + ", Department = " + getDept() + ", Salary = " + getSalary()
			    + ", isManager = " + isManager() + ",\n    " + team.size()
				+ " Employee/s <===>  Team = " + team;
	}
}
