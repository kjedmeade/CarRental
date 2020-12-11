package com.skilldistillery.rental.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.rental.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
