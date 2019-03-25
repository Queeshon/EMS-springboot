/**
 * 
 */
package com.collabera.jump.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp = "[A-Za-z, ]*", message = "Entry must consist of letters from the English alphabet")
	@NotNull
	private String name;
	
	@Min(value = 18)
	@Max(value = 99)
	@NotNull
	private int age;
	
	private Gender gender;
	
	@Pattern(regexp = "[0-9]{10}", message = "Must be 10 digit integer")
	@NotNull
	private String phoneNumber;
	
	@Valid
	private Address address;

	public Person() {

	}

	public Person(String name, int age, Gender gender, String phoneNumber, Address address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}
}
