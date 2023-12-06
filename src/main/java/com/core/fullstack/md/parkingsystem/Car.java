package com.core.fullstack.md.parkingsystem;

public class Car extends Vehicle {

    private Long noPlate;
    private Long price;
    private Long date;

    public Car() {
        
    }

    public Car(Long noPlate, Long price, Long date) {
        this.noPlate = noPlate;
        this.price = price;
        this.date = date;
    }

    @Override
    Long getNoPlate() {
        return noPlate;
    }

    @Override
    Long getPrice() {
        return price;
    }

    @Override
    Long getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Car [noPlate=" + noPlate + ", price=" + price + ", date=" + date + "]";
    }
    
}
