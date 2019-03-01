package org.ivanov.Domain.repositories;

import org.ivanov.Domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
