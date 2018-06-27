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
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private boolean withDriver;
	@JoinColumn(name="user_id")
	private Car vehicule;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User driver;
	
	public Booking(){
		
	}
	
	public Booking(User user, LocalDateTime startDate, LocalDateTime endDate){
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Booking(User user, LocalDateTime startDate, LocalDateTime endDate, Car vehicule){
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
		this.vehicule = vehicule;
	}
	
	public Booking(User user, LocalDateTime startDate, LocalDateTime endDate, Car vehicule, boolean withDriver, User driver){
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
		this.vehicule = vehicule;
		this.withDriver = withDriver;
		this.driver = driver;
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

	public boolean isWithDriver() {
		return withDriver;
	}

	public void setWithDriver(boolean withDriver) {
		this.withDriver = withDriver;
	}

	public Car getVehicule() {
		return vehicule;
	}

	public void setVehicule(Car vehicule) {
		this.vehicule = vehicule;
	}

	public User getDriver() {
		return driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}
}
