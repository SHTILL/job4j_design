package ru.job4j.lsp.parking;

public class ParkingLot {
    private Car[] passengerCars;
    private Car[] trucks;

    public ParkingLot(int passengerCarNum, int truckNum) {
        this.passengerCars = new Car[passengerCarNum];
        this.trucks = new Car[truckNum];
    }

    private boolean park(Car[] a, Car c) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                a[i] = c;
                return true;
            }
        }
        return false;
    }

    public boolean parkPassenger(PassengerCar car) {
        return park(passengerCars, car);
    }
    public boolean parkTruck(Truck t) {
        if (park(trucks, t)) {
            return true;
        }
        int slots = t.getParkingSpaceRequired();
        int found = 0;
        int position = 0;
        for (int i = 0; i < passengerCars.length; i++) {
            if (passengerCars[i] == null) {
                if (found == 0) {
                    position = i;
                }
                found++;
                if (found == slots) {
                    for (int j = position; j < position + slots; j++) {
                        passengerCars[j] = t;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Car takeAway(String name) {
        Car[][] parks = {passengerCars, trucks};
        Car c = null;

        for (Car[] a: parks) {
            for (int i = 0; i < a.length; i++) {
                Car cur = a[i];
                if (cur != null) {
                    if (cur.getName().equals(name)) {
                        a[i] = null;
                        c = cur;
                    }
                }
            }
        }
        return c;
    }

    private int busySlots(Car[] a) {
        int busyCounter = 0;
        for (Car c: a) {
            if (c != null) {
                busyCounter++;
            }
        }
        return busyCounter;
    }

    public int getPassengerCarFreeSlots() {
        return passengerCars.length - busySlots(passengerCars);
    }

    public int getTrunkFreeSlots() {
        return trucks.length - busySlots(trucks);
    }

    public static void main(String[] args) {

    }
}
