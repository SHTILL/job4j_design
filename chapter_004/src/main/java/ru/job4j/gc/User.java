package ru.job4j.gc;

public class User {
    double d1;
    double d2;
    double d3;
    double d4;
    double d5;
    double d6;
    double d7;
    double d8;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("User is removed");
    }
}
