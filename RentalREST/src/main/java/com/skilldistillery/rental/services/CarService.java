package com.skilldistillery.rental.services;

import java.util.List;

import com.skilldistillery.rental.entities.Car;

public interface CarService {

	List<Car> listAllCars();

	Car findCarById(int id);

	Car createNewCar(Car car);

}


