package org.ivanov.domains.repositories;

import org.ivanov.domains.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
