package com.carrenting.spring.controller;

import com.carrenting.spring.entity.Booking;
import com.carrenting.spring.entity.BookingDao;
import com.carrenting.spring.entity.Car;
import com.carrenting.spring.entity.User;
import com.carrenting.spring.service.BookingService;
import com.carrenting.spring.service.CarService;
import com.carrenting.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/booking")
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;
    private final CarService carService;

    public BookingController(BookingService bookingService, UserService userService, CarService carService){
        this.bookingService = bookingService;
        this.userService = userService;
        this.carService = carService;
    }

    @GetMapping(value = "/")
    private String getBookingList(Model model){
        model.addAttribute("bookingList", bookingService.getAllBooking());
        return "bookingList";
    }

    @GetMapping(value = "/add")
    private String getBookingForm(Model model){
        BookingDao booking = new BookingDao();
        List<User> userList = userService.getAllUser();
        List<Car> carList = carService.getAllCar();
        List<String> usernameList = new ArrayList<>();
        List<String> licensePLateList = new ArrayList<>();


        for (User user :
                userList) {
            usernameList.add(user.getUsername());
        }
        for (Car car :
                carList) {
            licensePLateList.add(car.getLicensePlate());
        }
        model.addAttribute("usernameList", usernameList);
        model.addAttribute("licensePlateList", licensePLateList);
        model.addAttribute("newBooking", booking);
        return "bookingForm";
    }

    @PostMapping(value = "add")
    private String addBooking(@ModelAttribute("newBooking") BookingDao newBooking) throws Exception {
        try{
            Booking booking = new Booking();
            booking.setCar(carService.getCarFromLicensePlate(newBooking.getLicensePlate()));
            booking.setUser(userService.getUserFromUsername(newBooking.getUsername()));
            booking.setStartDate(newBooking.getStartDate());
            booking.setFinishDate(newBooking.getFinishDate());
            bookingService.addBooking(booking);
            return "redirect:/booking/";
        }
        catch (Exception ex){
            throw new Exception("Error");
        }
    }

    @GetMapping(value = "/delete/{id}")
    private String deleteBookingById(@PathVariable("id")int id, Model model){
        bookingService.delBookingFromId(id);
        return "redirect:/booking/";
    }
}
