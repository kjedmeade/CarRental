package com.skilldistillery.rental.services;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.rental.entities.Car;
import com.skilldistillery.rental.repositories.CarRepository;

@SpringBootTest
public class CarServiceTest {
	
	
	@Autowired
	private CarRepository repo;
	
	@Autowired
	private CarService cSvc;
	
	@Test
	@DisplayName("Get Type")
	void test1() {
		
		assertTrue(cSvc.listAllCars().size() >0);
	
	}
	
	@Test
	@DisplayName("Get Type")
	void test2() {
		
		assertTrue(cSvc.findCarById(1) != null);
		assertEquals("Sedan", cSvc.findCarById(1).getType());

	
	}
	
	@Test
	@DisplayName("Get Type")
	void test3() {
		Car newCar = new Car("Sedan");
		assertTrue(cSvc.createNewCar(newCar) != null);

	}
		
		
	


}
