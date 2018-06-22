package dev.repository;

import dev.entity.Vehicules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Vehicules,Integer> {
}
