package dev.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String immatriculation;
    String photo;
    int placeAvailable;
    String brand;
    String model;
    CarCategory category;

    public Car() {
    }

    public Car(String immatriculation, String photo, int placeAvailable, String brand, String model, CarCategory category) {
        this.immatriculation = immatriculation;
        this.photo = photo;
        this.placeAvailable = placeAvailable;
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

    public int getPlaceAvailable() {
        return placeAvailable;
    }

    public void setPlaceAvailable(int placeAvailable) {
        this.placeAvailable = placeAvailable;
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
        MicroUrbaines,
        MiniCitadines,
        CitadinesPolyvalentes,
        Compactes,
        BerlinesTailleS,
        BerlinesTailleM,
        BerlinesTailleL,
        SUV,
        ToutTerrains,
        PickUp
    }


}
