package com.carrenting.spring.controller;

import com.carrenting.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
