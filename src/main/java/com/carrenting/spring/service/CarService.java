package com.carrenting.spring.service;

import com.carrenting.spring.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();

    Car getCarFromId(int id);

    Car getCarFromLicensePlate(String licensePlate);

    void addCar(Car car);

    void delCarFromId(int id);
}
