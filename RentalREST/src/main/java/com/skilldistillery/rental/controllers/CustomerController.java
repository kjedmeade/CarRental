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

import com.skilldistillery.rental.entities.Customer;
import com.skilldistillery.rental.services.CustomerService;



@CrossOrigin({"*", "http://localhost:4208"})
@RequestMapping("api")
@RestController
public class CustomerController {


			@Autowired
			private CustomerService cSvc;
			
			//Get all customers
			@GetMapping("customer")
			public List<Customer> listAllCustomers(HttpServletResponse response) {
				List<Customer> customers = cSvc.listAllCustomers();
				if (customers == null) {
					response.setStatus(404);
				}
				return customers;
			}
			
//			@GetMapping("customer/unbooked")
//			public List<Customer> unbookedCustomers(HttpServletResponse response) {
//				List<Customer> customers = cSvc.findUnbookedCustomers();
//				if (customers == null) {
//					response.setStatus(404);
//				}
//				return customers;
//			}
//			@GetMapping("customer/booked")
//			public List<Customer> bookedCustomers(HttpServletResponse response) {
//				List<Customer> customers = cSvc.findBookedCustomers();
//				if (customers == null) {
//					response.setStatus(404);
//				}
//				return customers;
//			}
//			
//			@GetMapping("customer/{id}")
//			public Customer listCustomerById(@PathVariable Integer id, HttpServletResponse response) {
//				Customer customer  = cSvc.findCustomerById(id);
//				if (customer == null) {
//					response.setStatus(404);
//				}
//				return customer;
//			}
			
			//Create a new Customer : Test via Postman
			//Set response status codes
			
			@PostMapping("customer")
			public Customer createNewCustomer(@RequestBody Customer customer, HttpServletResponse response, HttpServletRequest request) {
				customer = cSvc.createNewCustomer(customer);
				if (customer == null) {
					response.setStatus(404);
				}
				else {
					response.setStatus(201);
				StringBuffer url = request.getRequestURL();
				url.append("/").append(customer.getId());
				response.setHeader("Location", url.toString());
				
				}
				return customer;
			}
			
//			@PutMapping("customer/{id}")
//			public Customer updatePost(@RequestBody Customer customer, @PathVariable int id, HttpServletResponse response) {
//				customer = cSvc.updateCustomer(id, customer);
//				try {
//					if (customer == null) {
//
//						response.setStatus(404);
//					} 
//				} catch (Exception e) {
//					// TODO: handle exception
//					response.setStatus(400);
//					customer =null;
//				}
//				return customer;
//			}
//			@DeleteMapping("customer/{id}")
//			public void deleteCustomer(@PathVariable Integer id, HttpServletResponse response) {
//				try {
//					
//				boolean deleted =cSvc.deleteCustomer(id);
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



