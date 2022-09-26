package com.carrenting.spring.service;

import com.carrenting.spring.entity.Car;
import com.carrenting.spring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.selAllCar();
    }

    @Override
    public Car getCarFromId(int id) {
        return carRepository.selCarFromId(id);
    }

    @Override
    public Car getCarFromLicensePlate(String licensePlate) {
        return carRepository.selCarFromLicensePlate(licensePlate);
    }

    @Override
    public void addCar(Car car) {
        carRepository.insCar(car);
    }

    @Override
    public void delCarFromId(int id) {
        carRepository.delCarFromId(id);
    }

    @Override
    public List<Car> getCarAvailable(LocalDate startDate, LocalDate finishDate) {
        List<Car> carBooked = carRepository.getCarBooked(startDate, finishDate);
        //Tutte le Macchine
        List<Car>allCars = carRepository.selAllCar();
        //Tutte le macchine disponibili
        Set<Car> carSet = new HashSet<>();
        ArrayList<Car> carsDisp = new ArrayList<>();
        if (carBooked.isEmpty()) {
            carSet.addAll(allCars);
        }
        for (Car car : allCars) {
            for (Car ob : carBooked) {
                if (ob.getId() != car.getId()){
                    carSet.add(car);
                }
            }
        }
        carsDisp.addAll(carSet);

        return carsDisp;
    }
}
