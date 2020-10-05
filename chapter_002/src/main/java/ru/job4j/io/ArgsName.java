package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) throws IllegalArgumentException {
        String v = values.get(key);
        if (v == null) {
            throw new IllegalArgumentException();
        }
        return v;
    }

    private void parse(String[] args) {
        Pattern p = Pattern.compile("^-\\w+=\\S+$");
        for (String arg: args) {
            Matcher m = p.matcher(arg);
            if (m.matches()) {
                String[] tokens = arg.split("=");
                String key = tokens[0].substring(1);
                String value = tokens[1];
                values.put(key, value);
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(jvm.get("out"));
    }
}
