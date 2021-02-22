package ru.job4j.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingLotTest {

    @Test
    public void whenParkPassengerCar() {
        ParkingLot p = new ParkingLot(3, 1);
        PassengerCar auto = new PassengerCar("Kolya");
        assertTrue(p.parkPassenger(auto));
        assertEquals(2, p.getPassengerCarFreeSlots());
        assertEquals(1, p.getTrunkFreeSlots());
        assertThat(auto, is(p.takeAway("Kolya")));
        assertEquals(3, p.getPassengerCarFreeSlots());
        assertEquals(1, p.getTrunkFreeSlots());
    }

    @Test
    public void whenParkTrunkInTrunkSpace() {
        ParkingLot p = new ParkingLot(3, 1);
        Truck truck = new Truck("Kolya", 2);
        assertTrue(p.parkTruck(truck));
        assertEquals(3, p.getPassengerCarFreeSlots());
        assertEquals(0, p.getTrunkFreeSlots());
        assertThat(truck, is(p.takeAway("Kolya")));
        assertEquals(3, p.getPassengerCarFreeSlots());
        assertEquals(1, p.getTrunkFreeSlots());
    }

    @Test
    public void whenParkTrunkInPassengerCarSpace() {
        ParkingLot p = new ParkingLot(3, 0);
        Truck trunk = new Truck("Kolya", 2);
        assertTrue(p.parkTruck(trunk));
        assertEquals(1, p.getPassengerCarFreeSlots());
        assertEquals(0, p.getTrunkFreeSlots());
        assertThat(trunk, is(p.takeAway("Kolya")));
        assertEquals(3, p.getPassengerCarFreeSlots());
        assertEquals(0, p.getTrunkFreeSlots());
    }

    @Test
    public void whenNoSpacePassengerCar() {
        ParkingLot p = new ParkingLot(1, 0);
        PassengerCar auto1 = new PassengerCar("Kolya");
        PassengerCar auto2 = new PassengerCar("Petya");
        assertTrue(p.parkPassenger(auto1));
        assertFalse(p.parkPassenger(auto2));
    }

    @Test
    public void whenNoSpaceTruck() {
        ParkingLot p = new ParkingLot(2, 0);
        Truck truck = new Truck("Kolya", 3);
        assertFalse(p.parkTruck(truck));
    }
}