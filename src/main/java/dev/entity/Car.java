package dev.entity;

import java.util.List;
import javax.persistence.*;

@Entity
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id")
    int id;
    String immatriculation;
    int availableSeats;
    String brand;
    String model;
    @OneToMany
    private List<Booking> booking;


    public Car() {
    }

    public Car(String immatriculation, int availableSeats, String brand, String model) {
        this.immatriculation = immatriculation;
        this.availableSeats = availableSeats;
        this.brand = brand;
        this.model = model;
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
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
