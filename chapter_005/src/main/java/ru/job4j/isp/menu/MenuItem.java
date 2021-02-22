package ru.job4j.isp.menu;

public class MenuItem extends MenuComponent {
    public MenuItem(String name, Action action, MenuComponent parent) {
        super(name, action, parent);
    }

    @Override
    public void print() {
        System.out.println(name);
    }

    @Override
    public MenuComponent find(String name) {
        if (name.equals(this.name)) {
            return this;
        }
        return null;
    }
}
