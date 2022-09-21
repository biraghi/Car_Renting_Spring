package com.carrenting.spring.service;

import com.carrenting.spring.entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBooking();

    Booking getBookingFromId(int id);

    void addBooking(Booking booking);

    void delBookingFromId(int id);
}
