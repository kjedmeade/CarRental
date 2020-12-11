package com.skilldistillery.rental.services;

import java.util.List;

import com.skilldistillery.rental.entities.Rental;

public interface RentalService {

	List<Rental> listAllRentals();


	Rental createNewRental(Rental rental);

	


	List<Rental> findBookedRentals();

	List<Rental> findUnbookedRentals();


	boolean deleteRental(int id);


	Rental updateRental(int id, Rental rental);


	Rental findRentalById(int id);

	
}
