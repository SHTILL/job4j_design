package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VacationSheet {
    List<Employee> l = new ArrayList<>();

    public void add(Employee e) {
        l.add(e);
    }

    public int getNumberEmployeesInVacation() {
        return l.size();
    }

    public static void main(String[] args) throws Exception {
        List<Employee> allowedToSummerVacation = new ArrayList<>();
        allowedToSummerVacation.add(new Employee());
        allowedToSummerVacation.add(new PolarEmployee());
        allowedToSummerVacation.add(new Employee());

        VacationSheet sheet = new VacationSheet();

        Calendar june = Calendar.getInstance();
        june.set(2020, Calendar.JUNE, 3);
        for (Employee e: allowedToSummerVacation) {
            e.onSummerHolidays(june, sheet);
        }

        if (sheet.getNumberEmployeesInVacation() != allowedToSummerVacation.size()) {
            throw new Exception("Alarm!!! LSP is not conformed!!!");
        }
    }
}
