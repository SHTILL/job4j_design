package ru.job4j.srp.design;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HTMLReportGenerator implements ReportGenerator {
    @Override
    public String generate(Report r) {
        Document doc = Document.createShell("");
        Element arrayTag = doc.body().appendElement("employees");
        for (Employee employee: r.getEmployees()) {
            Element eTag = arrayTag.appendElement("employee");
            eTag.attr("name", employee.getName());
            eTag.attr("hired", employee.getHired().getTime().toString());
            eTag.attr("fired", employee.getFired().getTime().toString());
            eTag.attr("salary", String.valueOf(employee.getSalary()));
        }
        return doc.toString();
    }
}
