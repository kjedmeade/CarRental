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

class CarTest {


		private static EntityManagerFactory emf;
		private EntityManager em;
		private Car car;
		
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
			car = em.find(Car.class, 1);

		}

		@AfterEach
		void tearDown() throws Exception {
			em.close();
			car = null;
		}
//Assert the list of Rentals is found in the database. Data may be retrieved from database in random order...hence no call to getRentals.get(i) 
		@Test
		@DisplayName("test for mapping Car entity")
		void test1() {
			assertNotNull(car);
			assertEquals("Sedan", car.getType());
			assertNotNull( car.getRentals());
			assertTrue( car.getRentals().size() >0);
			
// Can also test for specific number of rentals in database 
//			assertEquals(x,  car.getRentals().size());
		}
		

	}