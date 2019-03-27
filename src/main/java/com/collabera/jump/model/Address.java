/**
 * 
 */
package com.collabera.jump.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel(value = "Employee Address", description = "address template for employee")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String streetAddress;
	
	@Pattern(regexp = "[A-Za-z, ]*", message = "Entry must consist of letters from the English alphabet")
	@NotNull
	private String city;
	
	@Pattern(regexp = "[A-Za-z, ]*", message = "Entry must consist of letters from the English alphabet")
	@NotNull
	private String state;
	
	@Pattern(regexp = "[A-Za-z, ]*", message = "Entry must consist of letters from the English alphabet")
	@NotNull
	private String country;
	
	@Pattern(regexp = "[0-9]{5}", message = "Must be a positive 5-digit integer")
	@NotNull
	private String zipCode;
	
	@Id
	@GeneratedValue
	@NotNull
	private int id;

	public Address() {
	}
	
	public Address(Integer id, String streetAddress, String city, String state, String zipCode, String country) {
		this.id = id;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return streetAddress + ", " + city + ", " + state + ", " + country + " [" + zipCode + "]";
	}

	public int getId() {
		return id;
	}
	
}