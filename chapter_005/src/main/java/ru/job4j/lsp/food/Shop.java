package ru.job4j.lsp.food;

public class Shop extends Storage {
    @Override
    public boolean accept(Food f) {
        double p = calcPercent(f);
        return (p >= 0.25 && p < 1.0);
    }

    @Override
    public boolean needsDiscount(Food f) {
        double p = calcPercent(f);
        return (p >= 0.75 && p < 1.0);
    }
}
