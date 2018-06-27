package dev.repository;

import dev.entity.CarpoolBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarpoolBookingRepository extends JpaRepository<CarpoolBooking, Integer> {
}
