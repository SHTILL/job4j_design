package ru.job4j.srp.design;

import java.util.function.Predicate;

public class EmployeesReportEngine implements StoreEngine {
    private Store store;
    private ReportGenerator<? super ReportEmployees> reportGenerator;

    public EmployeesReportEngine(Store store, ReportGenerator<? super ReportEmployees> g) {
        this.store = store;
        this.reportGenerator = g;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return reportGenerator.generate(new ReportEmployees(store.findBy(filter)));
    }
}
