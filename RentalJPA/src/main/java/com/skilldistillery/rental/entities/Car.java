package com.skilldistillery.rental.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String  type;
	
	
	// Car has many rentals. Avoid recursion via JSON Ignore
	@JsonIgnore
	@OneToMany(mappedBy="car")
	private List<Rental>  rentals;
	

	
	public Car() {
		super();
	}



	public Car(String string) {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public List<Rental> getRentals() {
		return rentals;
	}



	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", type=" + type + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		return true;
	}


				
}
