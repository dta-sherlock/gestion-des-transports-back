package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Car;

public interface CarRepository  extends JpaRepository<Car, Integer>{

}
