package dev.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CompanyCarBooking extends Booking {

	@OneToOne
	private Car car;

	public CompanyCarBooking() {
		super();
	}

	public CompanyCarBooking(User user, LocalDateTime bookedAt, LocalDateTime returnsAt, Car car) {
		super(user, bookedAt, returnsAt);
		this.setCar(car);
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
