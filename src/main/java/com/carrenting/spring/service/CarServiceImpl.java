package com.carrenting.spring.service;

import com.carrenting.spring.entity.Car;
import com.carrenting.spring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCar() {
        return carRepository.selAllCar();
    }

    @Override
    public Car getCarFromId(int id) {
        return null;
    }

    @Override
    public Car getCarFromLicensePlate(String licensePlate) {
        return null;
    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void delCarFromId(int id) {

    }
}
