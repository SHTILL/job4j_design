package ru.job4j.lsp;

import java.util.Calendar;

public class PolarEmployee extends Employee {
    private boolean isSummerMonth(Calendar c) {
        int month = c.get(Calendar.MONTH);
        return month == Calendar.JULY;
    }

    void onSummerHolidays(Calendar c, VacationSheet sheet) {
        if (isSummerMonth(c)) {
            sheet.add(this);
        }
    }
}
