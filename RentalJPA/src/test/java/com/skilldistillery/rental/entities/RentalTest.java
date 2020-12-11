package com.skilldistillery.rental.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentalTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Rental rental;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("RentalPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		rental = em.find(Rental.class, 1);

	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		rental = null;
	}


	@Test
	@DisplayName("test for mapping Rental entity")
	void test1() {
		assertNotNull(rental);
		assertEquals("Sedan", rental.getCar().getType());
		assertEquals(2020, rental.getStartDate().getYear());
		assertEquals(9, rental.getStartDate().getMonthValue());
		assertEquals(9, rental.getStartDate().getDayOfMonth());
		assertEquals("9:00", rental.getStartTime());
		assertEquals(2020, rental.getEndDate().getYear());
		assertEquals(9, rental.getEndDate().getMonthValue());
		assertEquals(10, rental.getEndDate().getDayOfMonth());
		assertEquals("10:00", rental.getEndTime());
		assertEquals("Sedan", rental.getCar().getType());
		assertEquals("Mary", rental.getCustomer().getFirstName());
		assertEquals("May", rental.getCustomer().getLastName());


//		assertEquals("0000-000-0000", rental.getStartTime());
//		assertEquals("Sedan", rental.getEndDate());
//		assertEquals("0000-000-0000", rental.getEndTime());

	}

}
