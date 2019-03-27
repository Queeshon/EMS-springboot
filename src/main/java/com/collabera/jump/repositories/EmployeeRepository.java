package com.collabera.jump.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collabera.jump.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByName(String name); 
	
	@Query("SELECT e FROM Employee e WHERE e.address.streetAddress = :streetAddress")
	Employee findByStreetOnAddress(String streetAddress);
	
	List<Employee> findBySsn(String ssn);
	
	Employee findBySsnAndEmpId(String ssn, Integer empId);
	
	@Query(value = "SELECT phone_number FROM Employee WHERE emp_id = ?1", nativeQuery = true)
	BigInteger findPhoneNumberByEmployeeId(Integer empId);
	
}
