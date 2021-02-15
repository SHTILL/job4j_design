package ru.job4j.benchmark;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ScanWithSet implements FindMatches {
    @Override
    public boolean include(String[] origin, String[] line) {
        Set<String> s = new HashSet<>(Arrays.asList(origin));
        for (String l: line) {
            if (!s.contains(l)) {
                return false;
            }
        }
        return true;
    }
}
