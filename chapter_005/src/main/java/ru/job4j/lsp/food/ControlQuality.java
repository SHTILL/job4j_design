package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.time.OffsetDateTime.now;
import static java.time.temporal.ChronoUnit.DAYS;

public abstract class ControlQuality {
    protected static double calcPercent(Food f) {
        long lifeTime = DAYS.between(f.getCreateDate().toInstant(), f.getExpiryDate().toInstant());
        long beforeExpired = DAYS.between(now().toInstant(), f.getExpiryDate().toInstant());
        return ((float) beforeExpired / lifeTime);
    }
    abstract boolean checkQuality(Food f);

    public static void main(String[] args) {
        List<Storage> storage = new ArrayList<>();
        Storage wareHouse = new Warehouse(new ControlQualityStore());
        storage.add(wareHouse);
        Storage shop = new Shop(new ControlQualitySale());
        storage.add(shop);
        Storage trash = new Trash(new ControlQualitySpoiled());
        storage.add(trash);

        List<Food> food = new ArrayList<>();

        Calendar expired = Calendar.getInstance();
        Calendar created = Calendar.getInstance();
        expired.add(Calendar.DATE, 5);
        created.add(Calendar.DATE, -1);
        food.add(new Food("Bread", expired, created, 15.0, 0.0));

        expired = Calendar.getInstance();
        created = Calendar.getInstance();
        expired.add(Calendar.DATE, 5);
        created.add(Calendar.DATE, -5);
        food.add(new Food("Cheese", expired, created, 15.0, 0.0));

        expired = Calendar.getInstance();
        created = Calendar.getInstance();
        expired.add(Calendar.DATE, 2);
        created.add(Calendar.DATE, -20);
        food.add(new Food("Milk", expired, created, 15.0, 0.0));

        expired = Calendar.getInstance();
        created = Calendar.getInstance();
        expired.add(Calendar.DATE, -1);
        created.add(Calendar.DATE, -5);
        food.add(new Food("Meet", expired, created, 15.0, 0.0));

        for (Food f: food) {
            for (Storage s: storage) {
                s.add(f);
            }
        }

        System.out.println("Warehouse: " + wareHouse.getStored());
        System.out.println("Shop: " + shop.getStored());
        System.out.println("Trash: " + trash.getStored());
    }
}
