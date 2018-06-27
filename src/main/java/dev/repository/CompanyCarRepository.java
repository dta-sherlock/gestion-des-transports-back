package dev.repository;

import dev.entity.CompanyCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*")
public interface CompanyCarRepository extends JpaRepository<CompanyCar,Integer> {
}
