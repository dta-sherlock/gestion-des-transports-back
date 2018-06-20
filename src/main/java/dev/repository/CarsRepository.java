package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.entity.Car;

@Repository
public interface CarsRepository extends JpaRepository<Car, Integer> {
	List<Car> findAllByImmatriculationStartingWith(String start);
	// List<Car> findAllByBrandIsStartingWith(String start);
	// List<Car>
	// findAllByBrandIsStartingWithAndImmatriculationStartingWith(String
	// startBrand , String startImmat);
}
