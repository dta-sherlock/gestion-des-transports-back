package dev.entity;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "annonce")
public class Annonce {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "STARTING_ADRESS", nullable = false)
	private String startingAddress;

	@Column(name = "ARRIVAL_ADRESS", nullable = false)
	private String arrivalAddress;

	@Column(name = "TRAVEL_TIME", nullable = false)
	private Duration travelTime;

	@Column(name = "DISTANCE", nullable = false)
	private Double distance;

	@Embedded
	private CarpoolCar carpoolCar;

	@Column(name = "PLACES_AVAILABLE", nullable = false)
	private Integer placesAvailable;

	@Column(name = "TRAVEL_DATE", nullable = false)
	private LocalDateTime travelDate;

	@ManyToOne
	private User author;


	public Annonce() {
	}

	public Annonce(String startingAddress, String arrivalAddress, Duration travelTime, Double distance, Integer placesAvailable, LocalDateTime travelDate) {
		this.startingAddress = startingAddress;
		this.arrivalAddress = arrivalAddress;
		this.travelTime = travelTime;
		this.distance = distance;
		this.placesAvailable = placesAvailable;
		this.travelDate = travelDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartingAddress() {
		return startingAddress;
	}

	public void setStartingAddress(String startingAddress) {
		this.startingAddress = startingAddress;
	}

	public String getArrivalAddress() {
		return arrivalAddress;
	}

	public void setArrivalAddress(String arrivalAddress) {
		this.arrivalAddress = arrivalAddress;
	}

	public Duration getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Duration travelTime) {
		this.travelTime = travelTime;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public CarpoolCar getCarpoolCar() {
		return carpoolCar;
	}

	public void setCarpoolCar(CarpoolCar carpoolCar) {
		this.carpoolCar = carpoolCar;
	}

	public Integer getPlacesAvailable() {
		return placesAvailable;
	}

	public void setPlacesAvailable(Integer placesAvailable) {
		this.placesAvailable = placesAvailable;
	}

	public LocalDateTime getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDateTime travelDate) {
		this.travelDate = travelDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
