package com.skilldistillery.rental.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.rental.entities.Customer;
import com.skilldistillery.rental.repositories.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
		
		@Autowired 
		CustomerRepository repo;
		
//Stretch Goal: List all customers

		@Override
		public List<Customer> listAllCustomers() {
			return repo.findAll();
		}
		
//Stretch Goal: Finding a customer by it's id

//		@Override
//		public Customer findCustomerById(int id) {
//			Optional<Customer> customerOpt = repo.findById(id);
//			if (customerOpt.isPresent()) {
//				Customer customer = customerOpt.get();
//				return customer;
//			}
//			return null;
//			 
//		}
	
//Create/persist a new customer into the database
		@Override
		public Customer createNewCustomer(Customer customer) {

			repo.saveAndFlush(customer);

			return customer;
		}

//Stretch Goal: Updating a customer

//		@Override
//		public Customer updateCustomer(int id, Customer customer) {
//			Optional<Customer> customerOpt =repo.findById(id);
//			Customer customerToUpdate = null;
//			if (customerOpt.isPresent()) {
//				customerToUpdate=customerOpt.get();
//				if(customer.getFirstName() !=null) {customerToUpdate.setFirstName(customer.getFirstName());}
//				if(customer.getLastName() !=null) {customerToUpdate.setLastName(customer.getLastName());}
//				if(customer.getEmail() !=null) {customerToUpdate.setEmail(customer.getEmail());}
//				if(customer.getPhotoType() != null ) {customerToUpdate.setPhotoType(customer.getPhotoType());}
//				if(customer.getLocation() !=null) {customerToUpdate.setLocation(customer.getLocation());}
//				if(customer.getDuration() != 0) {customerToUpdate.setDuration(customer.getDuration());}
//				if(customer.getNotes() !=null) {customerToUpdate.setNotes(customer.getNotes());}
////				
//				repo.flush();
//		}
//			return customerToUpdate;
//		}
		
		
//Stretch Goal: Deleting Customer
//	
//		@Override
//		public boolean deleteCustomer(int id){
//			boolean deleted =false;
//			Optional<Customer> customerOpt= repo.findById(id);
//		 if (customerOpt.isPresent()) {
//			 Customer customer = customerOpt.get();
//			 repo.deleteById(id);
//			 deleted= true;
//		 }
//		 return deleted;
//			}
		
	
	
}


