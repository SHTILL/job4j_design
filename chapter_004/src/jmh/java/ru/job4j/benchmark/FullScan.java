package ru.job4j.benchmark;

public class FullScan implements FindMatches {
    @Override
    public boolean include(String[] origin, String[] line) {
        for (String l: line) {
            boolean found = false;
            for (String o: origin) {
                if (l.equals(o)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
