package ru.job4j.lsp.food;

public class ControlQualitySpoiled extends ControlQuality {
    @Override
    public boolean checkQuality(Food f) {
        return ControlQuality.calcPercent(f) < 0;
    }
}
