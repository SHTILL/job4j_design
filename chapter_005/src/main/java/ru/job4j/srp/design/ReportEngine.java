package ru.job4j.srp.design;

import java.util.function.Predicate;

public class ReportEngine implements Report {
    private Store store;
    private ReportGenerator generator;

    public ReportEngine(Store store, ReportGenerator g) {
        this.store = store;
        this.generator = g;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(generator.header());
        for (Employee employee : store.findBy(filter)) {
            text.append(generator.generate(employee));
        }
        return text.toString();
    }
}
