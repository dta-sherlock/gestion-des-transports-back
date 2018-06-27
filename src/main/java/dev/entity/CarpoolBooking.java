package dev.entity;

import javax.persistence.Entity;

@Entity
public class CarpoolBooking {
    private String startingAddress;
    private String arrivalAddress;
    private int availableSeats;
    private Car car;

    public CarpoolBooking() {

    }

    public CarpoolBooking(String startingAddress, String arrivalAddress, int availableSeats, Car car) {
        this.startingAddress = startingAddress;
        this.arrivalAddress = arrivalAddress;
        this.availableSeats = availableSeats;
        this.car = car;
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
}
