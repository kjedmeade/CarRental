package com.skilldistillery.rental.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.rental.entities.Customer;

@Service
public interface CustomerService {

	List<Customer> listAllCustomers();

	Customer createNewCustomer(Customer customer);
		
	
	
}


