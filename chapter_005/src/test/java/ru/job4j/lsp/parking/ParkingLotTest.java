package ru.job4j.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingLotTest {

    @Test
    public void whenParkPassengerCar() {
        ParkingLot p = new ParkingLot(3, 1);
        Car auto = new PassengerCar("Kolya");
        assertTrue(p.park(auto));
        assertEquals(2, p.getPassengerCarFreeSlots());
        assertEquals(1, p.getTrunkFreeSlots());
        assertThat(auto, is(p.takeAway("Kolya")));
        assertEquals(3, p.getPassengerCarFreeSlots());
        assertEquals(1, p.getTrunkFreeSlots());
    }

    @Test
    public void whenParkTrunkInTrunkSpace() {
        ParkingLot p = new ParkingLot(3, 1);
        Car trunk = new Truck("Kolya", 2);
        assertTrue(p.park(trunk));
        assertEquals(3, p.getPassengerCarFreeSlots());
        assertEquals(0, p.getTrunkFreeSlots());
        assertThat(trunk, is(p.takeAway("Kolya")));
        assertEquals(3, p.getPassengerCarFreeSlots());
        assertEquals(1, p.getTrunkFreeSlots());
    }

    @Test
    public void whenParkTrunkInPassengerCarSpace() {
        ParkingLot p = new ParkingLot(3, 0);
        Car trunk = new Truck("Kolya", 2);
        assertTrue(p.park(trunk));
        assertEquals(1, p.getPassengerCarFreeSlots());
        assertEquals(0, p.getTrunkFreeSlots());
        assertThat(trunk, is(p.takeAway("Kolya")));
        assertEquals(3, p.getPassengerCarFreeSlots());
        assertEquals(1, p.getTrunkFreeSlots());
    }

    @Test
    public void whenNoSpacePassengerCar() {
        ParkingLot p = new ParkingLot(1, 0);
        Car auto1 = new PassengerCar("Kolya");
        Car auto2 = new PassengerCar("Petya");
        assertTrue(p.park(auto1));
        assertFalse(p.park(auto2));
    }

    @Test
    public void whenNoSpaceTruck() {
        ParkingLot p = new ParkingLot(2, 0);
        Car truck = new Truck("Kolya", 3);
        assertFalse(p.park(truck));
    }
}