package ru.job4j.gc;

public class UserCollector {
    public static void main(String[] args) {
        for (int i = 0; i < 12501; i++) {
            new User();
        }
    }
}
