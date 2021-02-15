package ru.job4j.srp.design;

public interface ReportGenerator {
    String header();
    String generate(Employee e);
}
