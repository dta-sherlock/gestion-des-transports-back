package dev.repository;

import dev.domain.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface VersionRepository extends JpaRepository<Version,Integer> {
}
