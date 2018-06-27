package dev.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class CompanyCarBookingDriver extends CompanyCarBooking{
	
	//private Driver driver;
	
	public CompanyCarBookingDriver(){
		super();
	}
	
	public CompanyCarBookingDriver(User user, LocalDateTime bookedAt, LocalDateTime returnsAt, Car car){
		super(user, bookedAt, returnsAt, car);
	}
}
