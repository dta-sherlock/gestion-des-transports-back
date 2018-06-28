package dev.repository;

import dev.entity.CarpoolBooking;
import dev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarpoolBookingRepository extends JpaRepository<CarpoolBooking, Integer> {

    List<CarpoolBooking> findByCreator(User creator);
    CarpoolBooking findById(int id);
}
