package ru.job4j.ocp;

import java.util.ArrayList;
import java.util.HashSet;

public class EmployeeHighestSalary {
    public Employee findHighestSalaryInArrayList(ArrayList<Employee> employeeArrayList) {
        int maxSalary = 0;
        Employee bestEarner = null;
        for (Employee e: employeeArrayList) {
            if (e.getSalary() > maxSalary) {
                maxSalary = e.getSalary();
                bestEarner = e;
            }
        }
        return bestEarner;
    }

    public Employee findHighestSalaryInHashSet(HashSet<Employee> employeeHashSet) {
        int maxSalary = 0;
        Employee bestEarner = null;
        for (Employee e: employeeHashSet) {
            if (e.getSalary() > maxSalary) {
                maxSalary = e.getSalary();
                bestEarner = e;
            }
        }
        return bestEarner;
    }

    public Employee findHighestSalaryInArray(Employee[] employeeArray) {
        int maxSalary = 0;
        Employee bestEarner = null;
        for (Employee e: employeeArray) {
            if (e.getSalary() > maxSalary) {
                maxSalary = e.getSalary();
                bestEarner = e;
            }
        }
        return bestEarner;
    }
}
