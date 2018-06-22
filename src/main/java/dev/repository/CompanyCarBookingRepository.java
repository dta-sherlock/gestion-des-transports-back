package dev.repository;

import dev.entity.CompanyCarBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyCarBookingRepository extends JpaRepository<CompanyCarBooking, Integer> {
}
