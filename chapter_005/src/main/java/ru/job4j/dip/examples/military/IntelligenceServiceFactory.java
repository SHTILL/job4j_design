package ru.job4j.dip.examples.military;

public class IntelligenceServiceFactory implements SoldierFactory {
    @Override
    public Weapon getWeapon() {
        return new Gun();
    }

    @Override
    public Outfit getOutfit() {
        return new GreenOutfit();
    }
}
