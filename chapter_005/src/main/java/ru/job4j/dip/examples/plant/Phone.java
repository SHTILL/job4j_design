package ru.job4j.dip.examples.plant;

public class Phone extends Device {
    @Override
    public void calibrate() {
        System.out.println("Calibrate sensors screen");
    }

    @Override
    public void qualityControl() {
        System.out.println("Check battery");
    }

    @Override
    public void trim() {
        System.out.println("Polish case");
    }
}
