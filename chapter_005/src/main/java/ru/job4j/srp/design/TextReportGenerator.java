package ru.job4j.srp.design;

import java.util.Iterator;

public class TextReportGenerator implements ReportGenerator<ReportEmployees> {
    @Override
    public String generate(ReportEmployees r) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Iterator<Employee> i = r.getEmployees().iterator(); i.hasNext();) {
            Employee employee = i.next();
            text.append(employee.getName()).append(";")
            .append(employee.getHired()).append(";")
            .append(employee.getFired()).append(";")
            .append(employee.getSalary()).append(";");
            if (i.hasNext()) {
                text.append(System.lineSeparator());
            }
        }
        return text.toString();
    }
}
