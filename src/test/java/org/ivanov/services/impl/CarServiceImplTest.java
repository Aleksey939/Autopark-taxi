package org.ivanov.services.impl;

import org.ivanov.domains.entities.Car;
import org.ivanov.domains.entities.WorkDone;
import org.ivanov.domains.repositories.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceImplTest {
    @InjectMocks
    private org.ivanov.services.impl.CarServiceImpl carService;
    @Mock
    private CarRepository carRepository;
    @Test
    public void findAll() {
        //given:
        final List<Car> expectedResult = Arrays.asList(
                createCar(1),
                createCar(2)
        );
        //mocks:
        when(carRepository.findAll()).thenReturn(expectedResult);

        //when:
        final List<Car> actualResult = carService.findAll();

        //then:
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findById() {
    }

    @Test
    public void save() {
    }

    @Test
    public void deleteById() {
    }

    private Car createCar(int id) {
        Car car = new Car();
        car.setId(id);

        return car;
    }
}