package com.carrenting.spring.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class BookingDao {
    private String username;
    private String licensePlate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate finishDate;

    public BookingDao() {}

    public BookingDao(String username, String licensePlate, LocalDate startDate, LocalDate finishDate) {
        this.username = username;
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public String getUsername() {
        return username;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }
}
