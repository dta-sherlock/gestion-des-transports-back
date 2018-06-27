package dev.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CompanyCar extends Car {
    String photo;
    @Enumerated(EnumType.STRING) CarCategory category;

    public CompanyCar( ) {
    }

    public CompanyCar(String immatriculation, int availableSeats, String brand, String model, String photo, CarCategory category) {
        super(immatriculation, availableSeats, brand, model);
        this.photo = photo;
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
