package dev.repository;

import dev.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}
