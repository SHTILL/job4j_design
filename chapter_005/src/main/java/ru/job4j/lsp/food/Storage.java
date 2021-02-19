package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {
    private ControlQuality control;
    private List<Food> stored = new ArrayList<>();

    public Storage(ControlQuality control) {
        this.control = control;
    }

    public void storeFood(Food f) {
        stored.add(f);
    }

    public void add(Food f) {
        if (control.checkQuality(f)) {
            stored.add(f);
        }
    }

    public List<Food> getStored() {
        return stored;
    }
}
