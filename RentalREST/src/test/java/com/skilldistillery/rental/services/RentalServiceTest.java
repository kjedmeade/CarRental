package com.skilldistillery.rental.services;



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
import com.skilldistillery.rental.entities.Rental;
import com.skilldistillery.rental.repositories.RentalRepository;

@SpringBootTest
public class RentalServiceTest {
	
	
	@Autowired
	private RentalRepository repo;
	
	@Autowired
	private RentalService rSvc;
	
	@Test
	@DisplayName("Find All Rentals")
	void test1() {
		assertTrue(rSvc.listAllRentals().size() >0);
	
	}
	
	@Test
	@DisplayName("Get Single Rental")
	void test2() {
		
		assertTrue(rSvc.findRentalById(1) != null);
		assertEquals(2020, rSvc.findRentalById(1).getStartDate().getYear());
		assertEquals(9, rSvc.findRentalById(1).getStartDate().getMonthValue());
		assertEquals(9, rSvc.findRentalById(1).getStartDate().getDayOfMonth());

		assertEquals("9:00", rSvc.findRentalById(1).getStartTime());
		assertEquals(2020, rSvc.findRentalById(1).getEndDate().getYear());
		assertEquals(9, rSvc.findRentalById(1).getEndDate().getMonthValue());
		assertEquals(10, rSvc.findRentalById(1).getEndDate().getDayOfMonth());
		assertEquals("10:00", rSvc.findRentalById(1).getEndTime());
		assertEquals("Sedan", rSvc.findRentalById(1).getCar().getType());
		assertEquals("Mary", rSvc.findRentalById(1).getCustomer().getFirstName());
		assertEquals("May", rSvc.findRentalById(1).getCustomer().getLastName());
		

	
	}
	
	@Test
	@DisplayName("Create New Rental")
	void test3() {
		Rental newRental = new Rental(10,10,10);
		assertNotNull(rSvc.createNewRental(newRental));

	}
		
		
	


}
