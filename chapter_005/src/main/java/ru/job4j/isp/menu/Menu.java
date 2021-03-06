package ru.job4j.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {
    private List<MenuComponent> items = new ArrayList<>();

    public Menu(String name, Action action, MenuComponent parent) {
        super(name, action, parent);
    }

    @Override
    public void add(MenuComponent i) {
        items.add(i);
    }

    @Override
    public void print() {
        System.out.print("-".repeat(level) + name + System.lineSeparator());
        for (MenuComponent i: items) {
            i.print();
        }
    }

    public MenuComponent find(String name) {
        MenuComponent found = null;
        if (name.equals(this.name)) {
            found = this;
        } else {
            for (MenuComponent m: items) {
                found = m.find(name);
                if (found != null) {
                    break;
                }
            }
        }
        return found;
    }
}
