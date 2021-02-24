package ru.job4j.dip.examples.military;

public class MilitaryDip {
    public static Soldier train(SoldierFactory f) {
        return new Soldier(f.getWeapon(), f.getOutfit());
    }

    public static void main(String[] args) {
        Soldier s1 = MilitaryDip.train(new NavyFactory());
        Soldier s2 = MilitaryDip.train(new InfantryFactory());
        Soldier s3 = MilitaryDip.train(new IntelligenceServiceFactory());
    }
}
