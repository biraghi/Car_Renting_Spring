package com.carrenting.spring.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="manufacturer")
    private String manufacturer;

    @Column(name="model")
    private String model;

    @Column(name="year_registration")
    private LocalDate yearRegistration;

    @Column(name="license_plate")
    private String licensePlate;

    @Column(name="type_name")
    private String typeName;

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Booking> bookings;

    public Car(){}

    public Car(String manufacturer, String model, LocalDate yearRegistration, String licensePlate, String typeName) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearRegistration = yearRegistration;
        this.licensePlate = licensePlate;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){this.id = id;}

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYearRegistration() {
        return yearRegistration;
    }

    public void setYearRegistration(LocalDate yearRegistration) {
        this.yearRegistration = yearRegistration;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", yearRegistration='" + yearRegistration + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
