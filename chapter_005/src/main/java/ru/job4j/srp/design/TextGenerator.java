package ru.job4j.srp.design;

public class TextGenerator implements ReportGenerator {
    @Override
    public String header() {
        return "Name; Hired; Fired; Salary;" + System.lineSeparator();
    }

    @Override
    public String generate(Employee employee) {
        return employee.getName() + ";"
                + employee.getHired() + ";"
                + employee.getFired() + ";"
                + employee.getSalary() + ";"
                + System.lineSeparator();
    }
}
