package com.collabera.jump.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.collabera.jump.model.Address;
import com.collabera.jump.model.Department;
import com.collabera.jump.model.Employee;
import com.collabera.jump.model.Gender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mock;
	
	@Test
	public void getEmployee() throws JsonProcessingException, Exception {
		
		Address a1 = new Address(1, "1 One St", "One City", "NY", "14068", "USA");
		
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
				Department.DEVELOPMENT
				);
		
		ObjectMapper objMapper = new ObjectMapper();
		
		mock.perform(get("/employee/1")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
	    	.andExpect(content().json(objMapper.writeValueAsString(emp)));
	}
	
	@Test
	public void createEmployee() throws JsonProcessingException, Exception {
		Address a99 = new Address(99, "99 Ninety-Nine St", "Ninety Nine City", "NY", "99099", "USA");
		
		Employee emp99 = new Employee(
				"999999999", 
				99, 
				"Developer", 
				"ninety-nine@collabera.com", 
				"Ninety Nine", 
				23, 
				"1234567890", 
				900000, 
				true, 
				true, 
				Gender.MALE, 
				a99,
				Department.DEVELOPMENT
				);
		
		ObjectMapper objMapper = new ObjectMapper();
		
		mock.perform(post("/employee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objMapper.writeValueAsString(emp99)))
		.andExpect(status().isCreated())
		.andExpect(content().json(objMapper.writeValueAsString(emp99)));
	}
	
	@Test
	public void updateEmployee() throws JsonProcessingException, Exception {
		
		Address a1 = new Address(1, "1 One St", "One City", "NY", "14068", "USA");
		
		Employee emp = new Employee(
				"111111111", 
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
				Department.DEVELOPMENT
				);
		
		ObjectMapper objMapper = new ObjectMapper();
		System.out.println(objMapper.writeValueAsString(emp));
		mock.perform(put("/employee/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objMapper.writeValueAsString(emp)))
			.andExpect(status().isOk())
	    	.andExpect(content().json(objMapper.writeValueAsString(emp)));
	}
	
	@Test
	public void deleteEmployee() throws Exception {
		mock.perform(delete("/employee/2").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("Employee Deleted"));
	}
	
}
