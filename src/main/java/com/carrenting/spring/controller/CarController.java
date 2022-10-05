package com.carrenting.spring.controller;

import com.carrenting.spring.entity.BookingForm;
import com.carrenting.spring.entity.Car;
import com.carrenting.spring.service.CarService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping
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
    private String updateCar(@Valid @ModelAttribute("newCar") Car newCar, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "carForm";
        }
        Car oldCar = carService.getCarFromId(newCar.getId());
        if(carService.getCarFromLicensePlate(newCar.getLicensePlate()) != null && !newCar.getLicensePlate().equals(oldCar.getLicensePlate())){
            model.addAttribute("error", "License Plate is present");
            return "carForm";
        }
        carService.addCar(carService.setParamForUpdate(oldCar, newCar));

        return "redirect:/car";
    }

    @GetMapping(value = "/add")
    private String getCarForm(Model model){
        Car car = new Car();
        model.addAttribute("newCar", car);
        return "carForm";
    }

    @PostMapping(value = "/add")
    private String addCar(@Valid @ModelAttribute("newCar") Car car, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "carForm";
        }
        if(carService.getCarFromLicensePlate(car.getLicensePlate()) == null){
            carService.addCar(car);
            return "redirect:/car";
        }
        model.addAttribute("error", "License Plate is present");
        return "carForm";

    }

    @GetMapping(value = "/delete/{id}")
    private String deleteCarById(@PathVariable("id")int id, Model model){
        carService.delCarFromId(id);
        return "redirect:/car";
    }

    @GetMapping(value="/available")
    private String getRangeDate(){
        return "rangeDate";
    }

    @GetMapping(value = "/available/list")
    private String getCarAvailable(@RequestParam("startDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                   @RequestParam("finishDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishDate,
                                   Model model){
        BookingForm booking = new BookingForm();
        List<Car> carBooked = carService.getCarAvailable(startDate, finishDate);
        model.addAttribute("startDate", startDate);
        model.addAttribute("finishDate", finishDate);
        model.addAttribute("carBooked", carBooked);
        model.addAttribute("newBooking", booking);
        return "carAvailable";

    }
}
