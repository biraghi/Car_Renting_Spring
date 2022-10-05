package com.carrenting.spring.service;

import com.carrenting.spring.entity.Booking;
import com.carrenting.spring.entity.BookingForm;
import com.carrenting.spring.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final CarService carService;

    public BookingServiceImpl(BookingRepository bookingRepository, UserService userService, CarService carService){
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.carService = carService;
    }

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

    @Override
    public Booking setBookingFromForm(BookingForm bookingForm, String username) {
        Booking booking = new Booking();
        booking.setCar(carService.getCarFromLicensePlate(bookingForm.getLicensePlate()));
        booking.setUser(userService.getUserFromUsername(username));
        booking.setStartDate(bookingForm.getStartDate());
        booking.setFinishDate(bookingForm.getFinishDate());

        return booking;
    }
}
