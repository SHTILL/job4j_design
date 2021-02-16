package ru.job4j.srp.design;

import java.util.function.Predicate;

public interface StoreEngine {
    String generate(Predicate<Employee> filter);
}