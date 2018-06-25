package dev.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CarpoolCar {

	@Column
	private String immatriculation;
	@Column
	private String brand;
	@Column
	private String model;


	public CarpoolCar() {
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
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


}
