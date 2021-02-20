package ru.job4j.lsp.parking;

public class Car {
    private String name;
    private int parkingSpaceRequired;

    public Car(String name, int parkingSpaceRequired) {
        if (parkingSpaceRequired <= 0) {
            throw new IllegalArgumentException("Car must occupy at least 1 parking space");
        }
        this.parkingSpaceRequired = parkingSpaceRequired;
        this.name = name;
    }

    public int getParkingSpaceRequired() {
        return parkingSpaceRequired;
    }

    public String getName() {
        return name;
    }
}