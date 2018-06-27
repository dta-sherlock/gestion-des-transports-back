package dev.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CompanyCarBooking extends Booking {

    private boolean withDriver;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User driver;

    @OneToOne
    private CompanyCar companyCar;

    public CompanyCarBooking() {
        super();
    }

    public CompanyCarBooking(User creator, LocalDateTime startDate, LocalDateTime endDate, CompanyCar companyCar) {
        super(creator, startDate, endDate);
        this.companyCar = companyCar;
    }

    public CompanyCar getCompanyCar() {
        return companyCar;
    }

    public void setCompanyCar(CompanyCar companyCar) {
        this.companyCar = companyCar;
    }

    public boolean isWithDriver() {
        return withDriver;
    }

    public void setWithDriver(boolean withDriver) {
        this.withDriver = withDriver;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }
}