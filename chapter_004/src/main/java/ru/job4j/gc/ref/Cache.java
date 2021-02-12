package ru.job4j.gc.ref;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cache<T> {
    private Map<String, SoftReference<T>> cache = new HashMap<>();
    private Function<String, T> loader;

    public Cache(Function<String, T> loader) {
        this.loader = loader;
    }

    T get(String key) {
        SoftReference<T> r = cache.get(key);
        T value = null;
        if (r != null) {
            value = r.get();
        }
        if (r == null || value == null) {
            value = loader.apply(key);
            cache.put(key, new SoftReference<>(value));
        }
        return value;
    }

    private static class FileLoader implements Function<String, String> {
        @Override
        public String apply(String s) {
            String value = null;
            try (BufferedReader r = new BufferedReader(new FileReader(s))) {
                System.out.printf("Read %s" + System.lineSeparator(), s);
                value = r.lines().collect(Collectors.joining());
            } catch (FileNotFoundException e) {
                System.out.println("File is not found");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException");
            }
            return value;
        }
    }

    public static void main(String[] args) {
        String value;
        FileLoader loader = new FileLoader();
        Cache<String> cache = new Cache<>(loader);
        value = cache.get("Names.txt");
        System.out.println(value);
        value = cache.get("Names.txt");
        System.out.println(value);
        value = cache.get("Address.txt");
        System.out.println(value);
        value = cache.get("Address.txt");
        System.out.println(value);
    }
}
