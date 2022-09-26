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

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @GetMapping(value = "/")
    private String getBookingList(Model model){
        model.addAttribute("bookingList", bookingService.getAllBooking());
        return "bookingList";
    }
}
