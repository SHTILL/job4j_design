package ru.job4j.srp.design;

import com.google.gson.GsonBuilder;

public class JSONGenerator implements Generator<Object> {
    @Override
    public String generate(Object r) {
        return new GsonBuilder().create().toJson(r);
    }
}
