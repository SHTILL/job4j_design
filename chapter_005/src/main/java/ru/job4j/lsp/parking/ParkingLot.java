package ru.job4j.lsp.parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<String, Car> slots = new HashMap<>();
    private Car[] passengerCars;
    private Car[] trucks;

    public ParkingLot(int passengerCarNum, int truckNum) {
        this.passengerCars = new Car[passengerCarNum];
        this.trucks = new Car[truckNum];
    }

    public boolean park(Car c) {
        return false;
    }

    public Car takeAway(String name) {
        return null;
    }

    public int getPassengerCarFreeSlots() {
        return 0;
    }

    public int getTrunkFreeSlots() {
        return 0;
    }

    public static void main(String[] args) {

    }
}
