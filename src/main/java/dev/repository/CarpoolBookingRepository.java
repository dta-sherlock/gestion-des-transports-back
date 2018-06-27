package dev.repository;

import dev.entity.CarpoolBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Booking;

public interface CarpoolBookingRepository extends JpaRepository<CarpoolBooking, Integer> {

}
