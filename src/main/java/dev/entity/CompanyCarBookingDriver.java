package dev.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class CompanyCarBookingDriver extends CompanyCarBooking{
	
	//private Driver driver;
	
	public CompanyCarBookingDriver(){
		super();
	}
	
	public CompanyCarBookingDriver(LocalDateTime bookedAt, LocalDateTime returnsAt, Car car){
		super(bookedAt, returnsAt, car);
	}
}
