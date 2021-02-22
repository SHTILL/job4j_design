package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.List;

import static java.time.OffsetDateTime.now;
import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Storage {
    private List<Food> stored = new ArrayList<>();

    protected static double calcPercent(Food f) {
        long lifeTime = DAYS.between(f.getCreateDate().toInstant(), f.getExpiryDate().toInstant());
        long beforeExpired = DAYS.between(now().toInstant(), f.getExpiryDate().toInstant());
        return 1 - ((float) beforeExpired / lifeTime);
    }

    void add(Food f) {
        stored.add(f);
    }

    public abstract boolean accept(Food f);

    public List<Food> getStored() {
        return stored;
    }

    public boolean needsDiscount(Food f) {
        return false;
    }
}
