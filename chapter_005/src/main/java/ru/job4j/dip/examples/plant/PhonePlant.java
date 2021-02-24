package ru.job4j.dip.examples.plant;

public class PhonePlant extends PlantDip {
    @Override
    protected Device manufacture() {
        return new Phone();
    }
}
