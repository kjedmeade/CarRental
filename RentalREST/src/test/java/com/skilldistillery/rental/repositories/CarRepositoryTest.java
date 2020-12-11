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

@SpringBootTest
public class CarRepositoryTest {
	
	
	@Autowired
	private CarRepository repo;
	
	
	@Test
	@DisplayName("Display All")
	void test1() {
		Optional<Car> carOpt= repo.findById(1);
		assertTrue(carOpt.isPresent());
		Car car =carOpt.get();
		assertEquals("Sedan", car.getType());
		}
	
	@Test
	@DisplayName("Get Single car")
	void test2() {
		List<Car> cars = repo.findAll();
		assertNotNull(cars);
		assertTrue( cars.size() >0);


		}


}
