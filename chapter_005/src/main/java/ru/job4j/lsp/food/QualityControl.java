package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QualityControl {
    List<Storage> storage;

    public QualityControl(List<Storage> storage) {
        this.storage = storage;
    }

    public void distributeFood(Food f) {
        for (Storage s: storage) {
            if (s.needsDiscount(f)) {
                f.setDiscount(0.5);
            }
            if (s.accept(f)) {
                s.add(f);
                break;
            }
        }
    }

    public void resort() {
        List<Food> food = new ArrayList<>();
        for (Storage s: storage) {
            s.dumpTo(food);
        }
        for (Food f: food) {
            this.distributeFood(f);
        }
    }

    public static void main(String[] args) {
        List<Storage> storage = new ArrayList<>();
        Storage wareHouse = new Warehouse();
        storage.add(wareHouse);
        Storage shop = new Shop();
        storage.add(shop);
        Storage trash = new Trash();
        storage.add(trash);
        QualityControl q = new QualityControl(storage);

        Calendar expired = Calendar.getInstance();
        Calendar created = Calendar.getInstance();
        expired.add(Calendar.DATE, 5);
        created.add(Calendar.DATE, -1);
        q.distributeFood(new Food("Bread", expired, created, 15.0, 0.0));

        expired = Calendar.getInstance();
        created = Calendar.getInstance();
        expired.add(Calendar.DATE, 5);
        created.add(Calendar.DATE, -5);
        q.distributeFood(new Food("Cheese", expired, created, 15.0, 0.0));

        expired = Calendar.getInstance();
        created = Calendar.getInstance();
        expired.add(Calendar.DATE, 2);
        created.add(Calendar.DATE, -20);
        Food milk = new Food("Milk", expired, created, 15.0, 0.0);
        q.distributeFood(milk);

        expired = Calendar.getInstance();
        created = Calendar.getInstance();
        expired.add(Calendar.DATE, -1);
        created.add(Calendar.DATE, -5);
        q.distributeFood(new Food("Meet", expired, created, 15.0, 0.0));

        System.out.println("Warehouse: " + wareHouse.getStored());
        System.out.println("Shop: " + shop.getStored());
        System.out.println("Trash: " + trash.getStored());

        milk.setExpiryDate(expired);
        q.resort();

        System.out.println("Resort:");
        System.out.println("Warehouse: " + wareHouse.getStored());
        System.out.println("Shop: " + shop.getStored());
        System.out.println("Trash: " + trash.getStored());
    }
}
