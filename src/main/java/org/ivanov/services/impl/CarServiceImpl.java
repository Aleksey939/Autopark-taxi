package org.ivanov.services.impl;

import lombok.RequiredArgsConstructor;
import org.ivanov.domains.entities.Car;
import org.ivanov.domains.repositories.CarRepository;
import org.ivanov.services.CarService;
import org.springframework.stereotype.Service;
import lombok.NonNull;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    final CarRepository carRepository;
    @Override
    public List<Car> findAll() {return carRepository.findAll(); }

    @Override
    public Optional<Car> findById(@NonNull Integer carId) { return carRepository.findById(carId);}

    @Override
    public Car save(Car car) { return carRepository.save(car); }

    @Override
    public void deleteById(Integer carId) {carRepository.deleteById(carId); }
}
