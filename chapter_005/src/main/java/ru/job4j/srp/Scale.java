package ru.job4j.srp;

public class Scale {
    public double measureWeightKG() {
        return 0.0;
    }

    public void calibrate() {
    }

    public double convertToPounds(double weightKG) {
        return weightKG * 453.59237 / 1000;
    }
}
