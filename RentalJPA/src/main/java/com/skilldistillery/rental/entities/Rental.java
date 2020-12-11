package com.skilldistillery.rental.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "start_date")
	private LocalDate  startDate;
	
	@Column(name = "start_time")
	private String  startTime;
	
	@Column(name = "end_date")
	private LocalDate  endDate;
	
	@Column(name = "end_time")
	private String  endTime;
	
	// Rental has one car. 

	@ManyToOne
	@JoinColumn(name ="car_id")
	private Car car;
	
	// Rental has one customer. 

	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customer;

	public Rental() {
		super();
	}


	public Rental(String string) {
		// TODO Auto-generated constructor stub
	}


	public Rental(int i, int j, int k) {
		this.id =i;
		Car newCar = new Car();
		newCar.setId(j);
		this.car = newCar;
		Customer newCust = new Customer();
		newCust.setId(k);
		this.customer = newCust;
		
		
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", startDate=" + startDate + ", startTime=" + startTime + ", endDate=" + endDate
				+ ", endTime=" + endTime + ", car=" + car + ", customer=" + customer + "]";
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
		Rental other = (Rental) obj;
		if (id != other.id)
			return false;
		return true;
	}

}