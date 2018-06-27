package dev.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User creator;
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	public Booking(){
		
	}
	
	public Booking(User creator, LocalDateTime startDate, LocalDateTime endDate){
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setCreator(creator);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
