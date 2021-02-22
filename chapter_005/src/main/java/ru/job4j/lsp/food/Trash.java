package ru.job4j.lsp.food;

public class Trash extends Storage {
    @Override
    public boolean accept(Food f) {
        double p = calcPercent(f);
        return (p >= 1);
    }
}
