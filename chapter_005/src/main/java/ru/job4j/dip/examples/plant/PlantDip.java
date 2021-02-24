package ru.job4j.dip.examples.plant;

public abstract class PlantDip {
    public Device createPrototype() {
        Device d = manufacture();
        d.calibrate();
        return d;
    }

    public Device createMassProduction() {
        Device d = manufacture();
        d.qualityControl();
        d.trim();
        return d;
    }

    public Device createExhibitionSample() {
        Device d = manufacture();
        d.trim();
        return d;
    }

    protected abstract Device manufacture();
}