package com.skilldistillery.rental.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.rental.entities.Rental;
import com.skilldistillery.rental.repositories.RentalRepository;

@Service
public class RentalServiceImpl implements RentalService {
		
		@Autowired 
		RentalRepository repo;
		

		//List all rentals

		@Override
		public List<Rental> listAllRentals() {
			return repo.findAll();
		}
		
		//Stretch Goal: Find unbooked rentals

		@Override
		public List<Rental> findUnbookedRentals() {
			return repo.findByStartDateIsNullAndEndDateIsNull();
		}
		
		//Stretch Goal: Find booked rentals


		@Override
		public List<Rental> findBookedRentals() {
			return repo.findByStartDateIsNotNullAndEndDateIsNotNull();
		}
	
		//Find a rental by it's id

		@Override
		public Rental findRentalById(int id) {
			Optional<Rental> rentalOpt = repo.findById(id);
			if (rentalOpt.isPresent()) {
				Rental rental = rentalOpt.get();
				return rental;
			}
			return null;
			 
		}
	
		//Create/persist a new rental into the database

		@Override
		public Rental createNewRental(Rental rental) {

			repo.saveAndFlush(rental);

			return rental;
		}



		//Stretch Goal: Update rental

	
		@Override
		public Rental updateRental(int id, Rental rental) {
			Optional<Rental> rentalOpt =repo.findById(id);
			Rental rentalToUpdate = null;
			if (rentalOpt.isPresent()) {
				rentalToUpdate=rentalOpt.get();
				if(rental.getStartDate() !=null) {rentalToUpdate.setStartDate(rental.getStartDate() );}
				if(rental.getStartTime() !=null) {rentalToUpdate.setStartTime(rental.getStartTime());}
				if(rental.getEndDate() !=null) {rentalToUpdate.setEndDate(rental.getEndDate());}
				if(rental.getEndTime() != null ) {rentalToUpdate.setEndTime(rental.getEndTime());}
				if(rental.getCar() !=null) {rentalToUpdate.setCar(rental.getCar());}
				if(rental.getCustomer() != null) {rentalToUpdate.setCustomer(rental.getCustomer());}
				
				repo.flush();
		}
			return rentalToUpdate;
		}
	
		//Stretch Goal: Delete Rental


		@Override
		public boolean deleteRental(int id){
			boolean deleted =false;
			Optional<Rental> rentalOpt= repo.findById(id);
		 if (rentalOpt.isPresent()) {
			 Rental rental = rentalOpt.get();
			 repo.deleteById(id);
			 deleted= true;
		 }
		 return deleted;
			}


		
	
	
}


