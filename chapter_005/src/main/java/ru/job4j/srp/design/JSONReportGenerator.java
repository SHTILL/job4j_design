package ru.job4j.srp.design;

import com.google.gson.GsonBuilder;

public class JSONReportGenerator implements ReportGenerator {
    @Override
    public String generate(Report r) {
        return new GsonBuilder().create().toJson(r);
    }
}
