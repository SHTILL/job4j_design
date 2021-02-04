package ru.job4j.gc;

public class GCDemo {
    public static void main(String[] args) {
        GCInfo.info();
        for (int i = 0; i < 10; i++) {
            new Person(i, "N" + i);
        }
        System.gc();
        GCInfo.info();
    }
}
