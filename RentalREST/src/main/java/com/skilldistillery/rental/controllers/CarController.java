package com.skilldistillery.rental.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.rental.entities.Car;
import com.skilldistillery.rental.services.CarService;

@CrossOrigin({"*", "http://localhost:4208"})
@RequestMapping("api")
@RestController
public class CarController {


			@Autowired
			private CarService cSvc;
	
			
			//Stretch Goal: Get a list of all rentals

			
			@GetMapping("cars")
			public List<Car> listAllCars(HttpServletResponse response) {
				List<Car> cars = cSvc.listAllCars();
				if (cars == null) {
					response.setStatus(404);
				}
				return cars;
			}
			
//			@GetMapping("cars")
//			public List<Car> unbookedCars(HttpServletResponse response) {
//				List<Car> cars = cSvc.findUnbookedCars();
//				if (cars == null) {
//					response.setStatus(404);
//				}
//				return cars;
//			}
//			@GetMapping("cars/booked")
//			public List<Car> bookedCars(HttpServletResponse response) {
//				List<Car> cars = cSvc.findBookedCars();
//				if (cars == null) {
//					response.setStatus(404);
//				}
//				return cars;
//			}
			

			
			@GetMapping("cars/{id}")
			public Car listCarById(@PathVariable Integer id, HttpServletResponse response) {
				Car car  = cSvc.findCarById(id);
				if (car == null) {
					response.setStatus(404);
				}
				return car;
			}
			
			//Create a new Car: Test via Postman
			//Set response status codes


			
			@PostMapping("cars")
			public Car createNewCar(@RequestBody Car car, HttpServletResponse response, HttpServletRequest request) {
				car = cSvc.createNewCar(car);
				if (car == null) {
					response.setStatus(404);
				}
				else {
					response.setStatus(201);
				StringBuffer url = request.getRequestURL();
				url.append("/").append(car.getId());
				response.setHeader("Location", url.toString());
				
				}
				return car;
			}
			
//			@PutMapping("cars/{id}")
//			public Car updatePost(@RequestBody Car car, @PathVariable int id, HttpServletResponse response) {
//				car = cSvc.updateCar(id, car);
//				try {
//					if (car == null) {
//
//						response.setStatus(404);
//					} 
//				} catch (Exception e) {
//					// TODO: handle exception
//					response.setStatus(400);
//					car =null;
//				}
//				return car;
//			}
//			@DeleteMapping("cars/{id}")
//			public void deleteCar(@PathVariable Integer id, HttpServletResponse response) {
//				try {
//					
//				boolean deleted =cSvc.deleteCar(id);
//				if (deleted) {
//					response.setStatus(204);
//				}
//				else {
//					response.setStatus(404);
//				}
//				} catch (Exception e) {
//					// TODO: handle exception
//					response.setStatus(400);
//				}
//			
//			}
//		
			
			
		}



