package com.skilldistillery.rental.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.rental.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
	List<Rental> findByStartDateIsNullAndEndDateIsNull();
	List<Rental> findByStartDateIsNotNullAndEndDateIsNotNull();

}
