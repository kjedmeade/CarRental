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

@SpringBootTest
public class CustomerRepositoryTest {
	
	
	
	
	@Autowired
	private CustomerRepository repo;
	
	
	@Test
	@DisplayName("Find Indvidual Customer")
	void test1() {
		Optional<Customer> custOpt= repo.findById(1);
		assertTrue(custOpt.isPresent());
		Customer customer =custOpt.get();
		assertEquals("Mary", customer.getFirstName());
		assertEquals("May", customer.getLastName());
		}
	
	@Test
	@DisplayName("List all")
	void test2() {
		List<Customer> customers = repo.findAll();
		assertNotNull(customers);
		assertTrue( customers.size() >0);




	}
}
