package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    private static <T> T scan(List<T> value, Comparator<T> comparator, Predicate<Integer> f) {
        T extremum = value.get(0);
        for (T c: value) {
            if (f.test(comparator.compare(c, extremum))) {
                extremum = c;
            }
        }
        return extremum;
    }

    public static <T> T max(List<T> value, Comparator<T> comparator) {
        return scan(value, comparator, i -> i > 0);
    }

    public static <T> T min(List<T> value, Comparator<T> comparator) {
        return scan(value, comparator, i -> i < 0);
    }
}