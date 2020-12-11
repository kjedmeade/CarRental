package com.skilldistillery.rental.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.rental.entities.Car;
import com.skilldistillery.rental.repositories.CarRepository;


@Service
public class CarServiceImpl implements CarService {
		
		@Autowired 
		CarRepository repo;
		
//Create a method for listing all cars using the  car repository
		@Override
		public List<Car> listAllCars() {
			return repo.findAll();
		}
	
//Stretch Goal: Finding a car by it's id

		@Override
		public Car findCarById(int id) {
			Optional<Car> carOpt = repo.findById(id);
			if (carOpt.isPresent()) {
				Car car = carOpt.get();
				return car;
			}
			return null;
			 
		}
	
//Create a method for creating a car

		@Override
		public Car createNewCar(Car car) {

			repo.saveAndFlush(car);

			return car;
		}

//Stretch Goal: Updating a car
	
//		@Override
//		public Car updateCar(int id, Car car) {
//			Optional<Car> carOpt =repo.findById(id);
//			Car carToUpdate = null;
//			if (carOpt.isPresent()) {
//				carToUpdate=carOpt.get();
//				if(car.getFirstName() !=null) {carToUpdate.setFirstName(car.getFirstName());}
//				if(car.getLastName() !=null) {carToUpdate.setLastName(car.getLastName());}
//				if(car.getEmail() !=null) {carToUpdate.setEmail(car.getEmail());}
//				if(car.getPhotoType() != null ) {carToUpdate.setPhotoType(car.getPhotoType());}
//				if(car.getLocation() !=null) {carToUpdate.setLocation(car.getLocation());}
//				if(car.getDuration() != 0) {carToUpdate.setDuration(car.getDuration());}
//				if(car.getNotes() !=null) {carToUpdate.setNotes(car.getNotes());}
////				
//				repo.flush();
//		}
//			return carToUpdate;
//		}
		
		
		
//Stretch Goal: Deleting a car

//	
//		@Override
//		public boolean deleteCar(int id){
//			boolean deleted =false;
//			Optional<Car> carOpt= repo.findById(id);
//		 if (carOpt.isPresent()) {
//			 Car car = carOpt.get();
//			 repo.deleteById(id);
//			 deleted= true;
//		 }
//		 return deleted;
//			}
		
	
	
}



