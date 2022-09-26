package com.carrenting.spring.service;

import com.carrenting.spring.entity.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarService {
    List<Car> getAllCar();

    Car getCarFromId(int id);

    Car getCarFromLicensePlate(String licensePlate);

    void addCar(Car car);

    void delCarFromId(int id);

    List<Car> getCarAvailable(LocalDate startDate, LocalDate finishDate);
}
