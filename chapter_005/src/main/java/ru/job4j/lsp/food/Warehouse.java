package ru.job4j.lsp.food;

public class Warehouse extends Storage {
    @Override
    public boolean accept(Food f) {
        double p = calcPercent(f);
        return (p < 0.25);
    }
}
