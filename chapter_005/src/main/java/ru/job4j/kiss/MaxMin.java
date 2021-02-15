package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    private static <T> T scan(List<T> value, Comparator<T> comparator, Comparator<Integer> f) {
        T extremum = value.get(0);
        for (T c: value) {
            if (f.compare(0, comparator.compare(extremum, c)) > 0) {
                extremum = c;
            }
        }
        return extremum;
    }

    public static <T> T max(List<T> value, Comparator<T> comparator) {
        return scan(value, comparator, Integer::compare);
    }

    public static <T> T min(List<T> value, Comparator<T> comparator) {
        return scan(value, comparator, (i1, i2) -> Integer.compare(i2, i1));
    }
}
