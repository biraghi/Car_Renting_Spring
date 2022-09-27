package com.carrenting.spring.controller;

import com.carrenting.spring.entity.BookingDao;
import com.carrenting.spring.entity.Car;
import com.carrenting.spring.service.CarService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/add")
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

    @GetMapping(value="/available")
    private String getRangeDate(){
        return "rangeDate";
    }

    @GetMapping(value = "/available/list")
    private String getCarAvailable(@RequestParam("startDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                   @RequestParam("finishDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishDate,
                                   Model model){
        BookingDao booking = new BookingDao();
        List<Car> carBooked = carService.getCarAvailable(startDate, finishDate);
        model.addAttribute("startDate", startDate);
        model.addAttribute("finishDate", finishDate);
        model.addAttribute("carBooked", carBooked);
        model.addAttribute("newBooking", booking);
        return "carAvailable";

    }
}
