package ru.job4j.dip.examples.plant;

public class ScalePlant extends PlantDip {
    @Override
    protected Device manufacture() {
        return new Scale();
    }
}
