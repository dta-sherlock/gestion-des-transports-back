package dev.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
public class CarpoolBooking extends Booking {

    private String startingAdress;
    private String arrivalAdress;
    private User driver;
    // TODO change String to CarpoolCar
    private String car;
    private int availableSeats;

    private ArrayList<User> carpoolerList;

    public CarpoolBooking() {
        super();
    }

    public CarpoolBooking(User user, LocalDateTime bookedAt, LocalDateTime returnsAt, String startingAdress,
                          String arrivalAdress, User driver, String car, int availableSeats) {
        super(user, bookedAt, returnsAt);
        this.startingAdress = startingAdress;
        this.arrivalAdress = arrivalAdress;
        this.driver = driver;
        this.car = car;
        this.availableSeats = availableSeats;
    }
}
