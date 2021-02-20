package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QualityControl {
    public static void distributeFood(List<Storage>  storage, List<Food> food) {
        for (Food f: food) {
            for (Storage s: storage) {
                s.accept(f);
            }
        }
    }

    public static void main(String[] args) {
        List<Storage> storage = new ArrayList<>();
        Storage wareHouse = new Warehouse(new AcceptanceCriteriaStore());
        storage.add(wareHouse);
        Storage shop = new Shop(new AcceptanceCriteriaSale());
        storage.add(shop);
        Storage trash = new Trash(new AcceptanceCriteriaSpoiled());
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

        QualityControl.distributeFood(storage, food);

        System.out.println("Warehouse: " + wareHouse.getStored());
        System.out.println("Shop: " + shop.getStored());
        System.out.println("Trash: " + trash.getStored());
    }
}
