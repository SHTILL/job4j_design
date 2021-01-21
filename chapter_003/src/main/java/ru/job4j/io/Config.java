package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {

        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String s = null;
            Pattern p = Pattern.compile("^\\w+=[\\S&&[^=]]+$");
            do {
                s = read.readLine();
                if (s != null) {
                    Matcher m = p.matcher(s);
                    if (m.matches()) {
                        String[] tokens = s.split("=");
                        values.put(tokens[0], tokens[1]);
                    }
                }
            } while (s != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public String value(String key) {
        return values.get(key);
    }

    public static void main(String[] args) {
        System.out.println(new Config("./chapter_002/data/pair_without_comment.properties"));
        Config c = new Config("./chapter_002/data/pairs_multiple.properties");
        c.load();
    }
}
