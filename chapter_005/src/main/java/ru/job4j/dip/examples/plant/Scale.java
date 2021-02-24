package ru.job4j.dip.examples.plant;

public class Scale extends Device {
    @Override
    public void calibrate() {
        System.out.println("Calibrate strain gauges");
    }

    @Override
    public void qualityControl() {
        System.out.println("Weigh reference weight");
    }

    @Override
    public void trim() {
        System.out.println("Just wipe");
    }
}
