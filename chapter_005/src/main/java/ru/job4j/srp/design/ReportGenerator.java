package ru.job4j.srp.design;

public interface ReportGenerator<T> {
    String generate(T r);
}
