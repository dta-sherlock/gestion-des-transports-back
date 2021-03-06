package dev.repository;

import dev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findById (int id);
}
