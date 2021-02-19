package ru.job4j.lsp.food;

public class ControlQualityStore extends ControlQuality {
    @Override
    public boolean checkQuality(Food f) {
        return ControlQuality.calcPercent(f) > 0.75;
    }
}