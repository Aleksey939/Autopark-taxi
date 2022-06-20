package org.ivanov.services;

import org.ivanov.domains.entities.Car;
import org.ivanov.domains.entities.Person;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();
    Optional<Car> findById(Integer carId);

    Car save(Car car);

    void deleteById(Integer carId);
}
