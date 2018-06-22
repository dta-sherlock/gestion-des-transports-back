package dev.repository;

import dev.entity.Vehicules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*")
public interface CarRepository extends JpaRepository<Vehicules,Integer> {
}
