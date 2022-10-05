package com.carrenting.spring.repository;

import com.carrenting.spring.entity.Booking;

import java.util.List;

public interface BookingRepository {
    List<Booking> selAllBooking();

    Booking selBookingFromId(int id);

    void insBooking(Booking booking);

    void delBookingFromId(int id);
}
