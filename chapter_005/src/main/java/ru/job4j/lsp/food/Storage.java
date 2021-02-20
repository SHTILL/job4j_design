package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {
    private AcceptanceCriteria controller;
    private List<Food> stored = new ArrayList<>();

    public Storage(AcceptanceCriteria controller) {
        this.controller = controller;
    }

    public void accept(Food f) {
        if (controller.checkQuality(f)) {
            stored.add(f);
        }
    }

    public List<Food> getStored() {
        return stored;
    }
}
