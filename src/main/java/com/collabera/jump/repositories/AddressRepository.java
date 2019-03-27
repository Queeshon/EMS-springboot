package com.collabera.jump.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.jump.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

	List<Address> findByStreetAddress(String street);
	
}
