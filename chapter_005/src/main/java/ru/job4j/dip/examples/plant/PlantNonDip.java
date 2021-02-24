package ru.job4j.dip.examples.plant;

public class PlantNonDip {
    private Device manufacture(String device) {
        return switch(device) {
            case "phone" -> new Phone();
            case "scale" -> new Scale();
            default -> null;
        };
    }

    public Device createPrototype(String device) {
        Device d = manufacture(device);
        d.calibrate();
        return d;
    }

    public Device createMassProduction(String device) {
        Device d = manufacture(device);
        d.qualityControl();
        d.trim();
        return d;
    }

    public Device createExhibitionSample(String device) {
        Device d = manufacture(device);
        d.trim();
        return d;
    }
}
