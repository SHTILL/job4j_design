package ru.job4j.srp.design;

import java.util.function.Predicate;

public class ReportEngine implements StoreEngine {
    private Store store;
    private Generator<? super Report> generator;

    public ReportEngine(Store store, Generator<? super Report> g) {
        this.store = store;
        this.generator = g;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return generator.generate(new Report(store.findBy(filter)));
    }
}
