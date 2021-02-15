package ru.job4j.srp.design;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    void add(Employee e);
    List<Employee> findBy(Predicate<Employee> filter);
}