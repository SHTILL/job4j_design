package ru.job4j.dip.examples.military;

public class NavyFactory implements SoldierFactory {
    @Override
    public Weapon getWeapon() {
        return new Grenade();
    }

    @Override
    public Outfit getOutfit() {
        return new BlueOutfit();
    }
}
