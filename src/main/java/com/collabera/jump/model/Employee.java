package com.collabera.jump.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value = "Employee", description = "employee template for EMS")
public class Employee extends Person implements Serializable, Comparable<Employee> {

	private static final long serialVersionUID = 1L;

	@Pattern(regexp = "[0-9]{9}", message = "Must be a 9-digit integer")
	@NotNull
	private String ssn;
	
	@Id
	@Positive(message = "Must be a positive integer")
	@NotNull(message = "Must enter an employee ID")
	private int emp_id;
	
	@Pattern(regexp = "[A-Za-z, ]*", message = "Entry must consist of letters from the English alphabet")
	@NotNull(message = "Must enter a job title")
	private String jobTitle;
	
	@Email(message = "Must enter an email")
	private String email;
	
	private Department dept;
	
	@NotNull(message = "Must enter a salary")
	private long salary;
	
	private boolean isManager;
	
	@NotNull(message = "Must be active")
	private boolean active;
	

	public Employee() {

	}

	public Employee(String ssn, int emp_id, String jobTitle, String email, String name, int age, String phoneNumber, long salary, boolean isManager, boolean active, Gender gender, Address address, Department dept) {
		super(name, age, gender, phoneNumber, address);
		
		this.ssn = ssn;
		this.emp_id = emp_id;
		this.email = email;
		this.jobTitle = jobTitle;
		this.dept = dept;
		this.salary = salary;
		this.isManager = isManager;
		this.active = true;
	}

	public int getEmpId() {
		return emp_id;
	}

	public void setEmpId(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Employee && this.getSsn() == ((Employee) obj).getSsn()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Employee o) {
		return (this.getName().length() - o.getName().length());
	}

	@Override
	public String toString() {
		return "(*)EmployeeId = " + emp_id + " <===> Name = " + getName() + ", Age = " + getAge() + ", Gender = "
				+ getGender() + ", ContactNo = " + getPhoneNumber() + ",\n                        Address = "
				+ getAddress() + ",\n                        SSN = " + ssn + ", eMail = " + email + ", Job Title = "
				+ jobTitle + ", Department = " + dept + ", Salary = " + salary
				+ ", isManager = " + isManager;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}