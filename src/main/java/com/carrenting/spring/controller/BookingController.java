package com.carrenting.spring.controller;

import com.carrenting.spring.entity.Booking;
import com.carrenting.spring.entity.BookingForm;
import com.carrenting.spring.entity.Car;
import com.carrenting.spring.service.BookingService;
import com.carrenting.spring.service.CarService;
import com.carrenting.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @GetMapping
    private String getBookingList(Model model){
        model.addAttribute("bookingList", bookingService.getAllBooking());
        return "bookingList";
    }

    @GetMapping(value = "/add")
    private String getBookingForm(Principal principal, Model model){
        BookingForm booking = new BookingForm();
        List<Car> carList = carService.getAllCar();
        List<String> licensePLateList = new ArrayList<>();
        String username = principal.getName();

        for (Car car :
                carList) {
            licensePLateList.add(car.getLicensePlate());
        }
        model.addAttribute("username", username);
        model.addAttribute("licensePlateList", licensePLateList);
        model.addAttribute("newBooking", booking);
        return "bookingForm";
    }

    @PostMapping(value = "/add")
    private String addBooking(@ModelAttribute("newBooking") BookingForm newBooking, Principal principal){
            bookingService.addBooking(bookingService.setBookingFromForm(newBooking, principal.getName()));
            return "redirect:/booking";


    }

    @GetMapping(value = "/delete/{id}")
    private String deleteBookingById(@PathVariable("id")int id, Model model){
        bookingService.delBookingFromId(id);
        return "redirect:/booking";
    }

    @GetMapping(value = "/approve/{id}")
    private String approveBookingById(@PathVariable("id")int id, Model model){
        Booking booking = bookingService.getBookingFromId(id);
        booking.setApprove(true);
        bookingService.addBooking(booking);
        return "redirect:/booking";
    }
}
