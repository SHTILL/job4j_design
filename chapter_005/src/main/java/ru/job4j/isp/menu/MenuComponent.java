package ru.job4j.isp.menu;

public abstract class MenuComponent {
    protected String name;
    protected Action action;
    protected int level;

    public abstract void print();

    public MenuComponent(String name, Action action, MenuComponent parent) {
        this.name = name;
        this.action = action;
        if (parent == null) {
            level = 0;
        } else {
            level = parent.level + 1;
            parent.add(this);
        }
    }

    public void doAction() {
        action.perform();
    }

    public void add(MenuComponent i) {
        throw new UnsupportedOperationException("Not implemented for this class");
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        MenuComponent top = new Menu("Список задач", () -> System.out.println("Top"), null);

        MenuComponent task1 = new Menu("Задача1", () -> System.out.println("Task"), top);
        MenuComponent task1subTask1 = new Menu("Задача1.1", () -> System.out.println("SubTask"), task1);
        MenuComponent task1subTask2 = new Menu("Задача1.2", () -> System.out.println("SubTask"), task1);
        MenuComponent task1subTask3 = new Menu("Задача1.3", () -> System.out.println("SubTask"), task1);

        MenuComponent task2 = new Menu("Задача2", () -> System.out.println("Task"), top);
        MenuComponent task2subTask1 = new Menu("Задача2.1", () -> System.out.println("SubTask"), task2);
        MenuComponent task2subTask2 = new Menu("Задача2.2", () -> System.out.println("SubTask"), task2);
        MenuComponent task2subTask3 = new Menu("Задача2.3", () -> System.out.println("SubTask"), task2);
        MenuComponent task2subSubTask1 = new Menu("Задача2.3.1", () -> System.out.println("SubTask"), task2subTask2);

        top.print();
    }
}
