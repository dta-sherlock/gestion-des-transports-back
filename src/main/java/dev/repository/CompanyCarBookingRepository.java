package dev.repository;

import dev.entity.CompanyCarBooking;
import dev.entity.User;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyCarBookingRepository extends JpaRepository<CompanyCarBooking, Integer> {
	List<CompanyCarBooking> findByCreator(User creator);
}
