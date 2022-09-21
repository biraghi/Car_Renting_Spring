package com.carrenting.spring.repository;

import com.carrenting.spring.entity.Car;
import com.carrenting.spring.entity.User;

import java.util.List;

public interface CarRepository {
    List<Car> selAllCar();

    Car selCarFromId(int id);

    Car selCarFromLicensePlate(String licensePlate);

    void insCar(Car car);

    void delCarFromId(int id);
}
