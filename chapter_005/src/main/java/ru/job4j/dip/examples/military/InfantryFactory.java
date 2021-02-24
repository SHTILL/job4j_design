package ru.job4j.dip.examples.military;

public class InfantryFactory implements SoldierFactory {
    @Override
    public Weapon getWeapon() {
        return new MachineGun();
    }

    @Override
    public Outfit getOutfit() {
        return new GreenOutfit();
    }
}
