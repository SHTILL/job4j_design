package ru.job4j.dip.examples.military;

public class MilitaryNonDip {
    public static Soldier train(String weapon, String outfit) {
        Weapon w = switch (weapon) {
            case "gun" -> new Gun();
            case "MachineGun" -> new MachineGun();
            case "grenade" -> new Grenade();
            default -> null;
        };

        Outfit o = switch (outfit) {
            case "green" -> new GreenOutfit();
            case "blue" -> new BlueOutfit();
            default -> null;
        };
        return new Soldier(w, o);
    }

    public static void main(String[] args) {
        Soldier navySoldier     = MilitaryNonDip.train("grenade", "blue");
        Soldier infantrySoldier = MilitaryNonDip.train("machineGun", "green");
        Soldier intelligenceServiceSoldier = MilitaryNonDip.train("gun", "green");
    }
}