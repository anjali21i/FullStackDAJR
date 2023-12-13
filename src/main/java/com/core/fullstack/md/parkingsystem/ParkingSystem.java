package com.core.fullstack.md.parkingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingSystem {

    private int totalLot;
    private List<Vehicle> vehicleList;

    public ParkingSystem() {

    }

    public ParkingSystem(int totalLot) {
        this.totalLot = totalLot;
        vehicleList = new ArrayList<>();
    }

    public int getTotalLot() {
        return totalLot;
    }

    public void setTotalLot(int totalLot) {
        this.totalLot = totalLot;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public boolean entry(Vehicle vehicle) {
        if (isLotAvail()) {
            vehicleList.add(vehicle);
            totalLot--;
            return true;
        }
        return false;
    }

    public Double exit(Vehicle vehicle) {
        if (vehicle != null && vehicleList.contains(vehicle)) {
            vehicleList.remove(vehicle);
            totalLot++;
            return totalPrice(vehicle.getPrice(), vehicle.getDate());
        }
        return null;
    }

    private boolean isLotAvail() {
        return totalLot > 0;
    }

    private Double totalPrice(Long price, Long time) {
        Date date = new Date();
        Long totTime = date.getTime() - time;
        return Double.valueOf(price * totTime);
    }

    public static void main(String arg[]) {

        ParkingSystem parking = new ParkingSystem(3);

        Bike bike = new Bike(72387L, 50L, 3L);
        Scooter scooter = new Scooter(37877L, 20L, 3L);

        parking.entry(bike);
        parking.entry(scooter);

        Scooter scooter2 = new Scooter(38877L, 20L, 1L);
        parking.entry(scooter2);
        System.out.println(parking.getVehicleList());
        System.out.println(parking.getVehicleList().toString());
    }
}
