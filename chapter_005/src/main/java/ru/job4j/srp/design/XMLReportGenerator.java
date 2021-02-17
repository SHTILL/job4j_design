package ru.job4j.srp.design;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLReportGenerator implements ReportGenerator<Object> {
    @Override
    public String generate(Object r) {
        try {
            return new XmlMapper().configure(SerializationFeature.INDENT_OUTPUT, true).writeValueAsString(r);
        } catch (JsonProcessingException ex) {
            return "";
        }
    }
}