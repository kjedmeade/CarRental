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

import com.skilldistillery.rental.entities.Rental;
import com.skilldistillery.rental.services.RentalService;

@CrossOrigin({"*", "http://localhost:4208"})
@RequestMapping("api")
@RestController
public class RentalController {


			@Autowired
			private RentalService rSvc;
			
			//List all Rentals
			
			@GetMapping("rentals")
			public List<Rental> listAllRentals(HttpServletResponse response) {
				List<Rental> rentals = rSvc.listAllRentals();
				if (rentals == null) {
					response.setStatus(404);
				}
				return rentals;
			}
			//Stretch Goal
			
			@GetMapping("rentals/unbooked")
			public List<Rental> unbookedRentals(HttpServletResponse response) {
				List<Rental> rentals = rSvc.findUnbookedRentals();
				if (rentals == null) {
					response.setStatus(404);
				}
				return rentals;
			}
			//Stretch Goal
			@GetMapping("rentals/booked")
			public List<Rental> bookedRentals(HttpServletResponse response) {
				List<Rental> rentals = rSvc.findBookedRentals();
				if (rentals == null) {
					response.setStatus(404);
				}
				return rentals;
			}
			//Stretch Goal
			@GetMapping("rentals/{id}")
			public Rental listRentalById(@PathVariable Integer id, HttpServletResponse response) {
				Rental rental  = rSvc.findRentalById(id);
				if (rental == null) {
					response.setStatus(404);
				}
				return rental;
			}
			
			//Create a new Rental: Test via Postman
			//Set response status codes
			
			@PostMapping("rentals")
			public Rental createNewRental(@RequestBody Rental rental, HttpServletResponse response, HttpServletRequest request) {
				rental = rSvc.createNewRental(rental);
				if (rental == null) {
					response.setStatus(404);
				}
				else {
					response.setStatus(201);
				StringBuffer url = request.getRequestURL();
				url.append("/").append(rental.getId());
				response.setHeader("Location", url.toString());
				
				}
				return rental;
			}
			//Stretch Goal
			@PutMapping("rentals/{id}")
			public Rental updatePost(@RequestBody Rental rental, @PathVariable int id, HttpServletResponse response) {
				rental = rSvc.updateRental(id, rental);
				try {
					if (rental == null) {

						response.setStatus(404);
					} 
				} catch (Exception e) {
					// TODO: handle exception
					response.setStatus(400);
					rental =null;
				}
				return rental;
			}
			
			//Stretch Goal
			@DeleteMapping("rentals/{id}")
			public void deleteRental(@PathVariable Integer id, HttpServletResponse response) {
				try {
					
				boolean deleted =rSvc.deleteRental(id);
				if (deleted) {
					response.setStatus(204);
				}
				else {
					response.setStatus(404);
				}
				} catch (Exception e) {
					// TODO: handle exception
					response.setStatus(400);
				}
			
			}
		
			
			
		}


