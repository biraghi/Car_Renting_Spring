package com.carrenting.spring.controller;

import com.carrenting.spring.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(value = "/")
    public String getBookingList(Model model){
        model.addAttribute("bookingList", bookingService.getAllBooking());
        return "bookingList";
    }
}
