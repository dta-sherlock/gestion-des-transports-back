package dev.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String immatriculation;
	String photo;
	int nombreDePlaces;
	String brand;
	String model;
	CarCategory category;

	@OneToOne
	private CompanyCarBooking companyCarBooking;

	public Car() {

	}

	public Car(String immatriculation, String photo, int nombreDePlaces, String brand, String model,
			CarCategory category) {
		this.immatriculation = immatriculation;
		this.photo = photo;
		this.nombreDePlaces = nombreDePlaces;
		this.brand = brand;
		this.model = model;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getNombreDePlaces() {
		return nombreDePlaces;
	}

	public void setNombreDePlaces(int nombreDePlaces) {
		this.nombreDePlaces = nombreDePlaces;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public CarCategory getCategory() {
		return category;
	}

	public void setCategory(CarCategory category) {
		this.category = category;
	}

	public enum CarCategory {
		MicroUrbaines, MiniCitadines, CitadinesPolyvalentes, Compactes, BerlinesTailleS, BerlinesTailleM, BerlinesTailleL, SUV, ToutTerrains, PickUp
	}
}