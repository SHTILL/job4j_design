package ru.job4j.srp.design;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "report")
public class ReportEmployees {
    @JacksonXmlElementWrapper(localName = "employees")
    @JacksonXmlProperty(localName = "employee")
    private List<Employee> employees;

    public ReportEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
