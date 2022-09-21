package com.carrenting.spring.service;

import com.carrenting.spring.entity.Booking;
import com.carrenting.spring.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.selAllBooking();
    }

    @Override
    public Booking getBookingFromId(int id) {
        return bookingRepository.selBookingFromId(id);
    }

    @Override
    public void addBooking(Booking booking) {
        bookingRepository.insBooking(booking);
    }

    @Override
    public void delBookingFromId(int id) {
        bookingRepository.delBookingFromId(id);
    }
}
