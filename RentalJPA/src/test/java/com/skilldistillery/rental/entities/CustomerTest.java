package com.skilldistillery.rental.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {


		private static EntityManagerFactory emf;
		private EntityManager em;
		private Customer customer;
		
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
			customer = em.find(Customer.class, 1);

		}

		@AfterEach
		void tearDown() throws Exception {
			em.close();
			customer = null;
		}

	//Assert the list of Rentals is found in the database. Data may be retrieved from database in random order...hence no call to getRentals.get(i) 

		@Test
		@DisplayName("test Customer Entity")
		void test1() {
			assertNotNull(customer);
			assertEquals("Mary", customer.getFirstName());
			assertEquals("May", customer.getLastName());
			assertEquals("0000-000-0000", customer.getCreditCard());
			assertNotNull( customer.getRentals());
			assertTrue( customer.getRentals().size() >0);
			
		}
		

	}
