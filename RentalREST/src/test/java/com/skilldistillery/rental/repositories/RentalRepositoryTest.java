package com.skilldistillery.rental.repositories;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.rental.entities.Car;
import com.skilldistillery.rental.entities.Customer;
import com.skilldistillery.rental.entities.Rental;

@SpringBootTest
public class RentalRepositoryTest {
	
	
	@Autowired
	private RentalRepository repo;
	
	
	@Test
	@DisplayName("Get single rental")
	void test1() {
		Optional<Rental> rentalOpt= repo.findById(1);
		assertTrue(rentalOpt.isPresent());
		Rental rental =rentalOpt.get();
		assertEquals("9:00", rental.getStartTime());
		}
	

	
	@Test
	@DisplayName("List all")
	void test2() {
		List<Rental> rentals = repo.findAll();
		assertNotNull(rentals);
		assertTrue( rentals.size() >0);




	}


}
