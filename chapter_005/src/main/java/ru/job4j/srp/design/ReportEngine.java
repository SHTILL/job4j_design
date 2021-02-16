package ru.job4j.srp.design;

import java.util.function.Predicate;

public class ReportEngine implements StoreEngine {
    private Store store;
    private ReportGenerator reportGenerator;

    public ReportEngine(Store store, ReportGenerator g) {
        this.store = store;
        this.reportGenerator = g;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return reportGenerator.generate(new Report(store.findBy(filter)));
    }
}
