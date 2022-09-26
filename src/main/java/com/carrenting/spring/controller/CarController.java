package com.carrenting.spring.controller;

import com.carrenting.spring.entity.Car;
import com.carrenting.spring.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping(value = "/")
    private String getCarList(Model model){
        model.addAttribute("carList", carService.getAllCar());
        return "carList";
    }

    @GetMapping(value = "/update/{id}")
    private String getCarFormUpdate(@PathVariable("id")int id, Model model)
    {
        Car car = carService.getCarFromId(id);
        model.addAttribute("newCar", car);
        return "carForm";
    }

    @PostMapping (value = "update/{id}")
    private String updateCar(@ModelAttribute("newCar") Car newCar) throws Exception {
        try{
            Car oldCar = carService.getCarFromId(newCar.getId());
            oldCar.setLicensePlate(newCar.getLicensePlate());
            oldCar.setManufacturer(newCar.getManufacturer());
            oldCar.setModel(newCar.getModel());
            oldCar.setTypeName(newCar.getTypeName());
            oldCar.setYearRegistration(newCar.getYearRegistration());
            carService.addCar(oldCar);

            return "redirect:/car/";
        }
        catch (Exception ex){
            throw new Exception("Error");
        }
    }

    @GetMapping(value = "/add")
    private String getCarForm(Model model){
        Car car = new Car();
        model.addAttribute("newCar", car);
        return "carForm";
    }

    @PostMapping(value = "add")
    private String addCar(@ModelAttribute("newCar") Car car) throws Exception {
        try{
            carService.addCar(car);
            return "redirect:/car/";
        }
        catch (Exception ex){
            throw new Exception("Error");
        }
    }

    @GetMapping(value = "/delete/{id}")
    private String deleteCarById(@PathVariable("id")int id, Model model){
        carService.delCarFromId(id);
        return "redirect:/car/";
    }
}
