package dev.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class CarpoolBooking extends Booking {
    private String startingAddress;
    private String arrivalAddress;
    private int availableSeats;
    private Car car;
    @ManyToMany
    private List<User> passengers;

    public CarpoolBooking() {

    }

    public CarpoolBooking(User creator, String startDate, String endDate, String startingAddress,
                          String arrivalAddress, int availableSeats, Car car) {
        super(creator, startDate, endDate);
        this.startingAddress = startingAddress;
        this.arrivalAddress = arrivalAddress;
        this.availableSeats = availableSeats;
        this.car = car;
    }

    public CarpoolBooking(User creator, LocalDateTime startDate, LocalDateTime endDate, String startingAddress,
                          String arrivalAddress, int availableSeats, Car car) {
        super(creator, startDate, endDate);
        this.startingAddress = startingAddress;
        this.arrivalAddress = arrivalAddress;
        this.availableSeats = availableSeats;
        this.car = car;
    }

    public void addPassenger(User passenger){
        if (this.availableSeats>0){
            this.availableSeats-=1;
            this.passengers.add(passenger);
        }
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<User> getPassengers() { return passengers; }

    public void setPassengers(List<User> passengers) { this.passengers = passengers; }
}