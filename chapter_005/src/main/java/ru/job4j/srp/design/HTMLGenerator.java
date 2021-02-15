package ru.job4j.srp.design;

public class HTMLGenerator implements ReportGenerator {
    @Override
    public String header() {
        return "<header> This is header </header>" + System.lineSeparator();
    }

    @Override
    public String generate(Employee employee) {
        return "<name>" + employee.getName() + "</name>"
                + "<hired>" + employee.getHired() + "</hired>"
                + "<fired>" + employee.getFired() + "</fired>"
                + "<salary>" + employee.getSalary() + "</salary>"
                + System.lineSeparator();
    }
}
