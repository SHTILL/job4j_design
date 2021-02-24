package ru.job4j.dip.examples.military;

public interface SoldierFactory {
    Weapon getWeapon();
    Outfit getOutfit();
}
