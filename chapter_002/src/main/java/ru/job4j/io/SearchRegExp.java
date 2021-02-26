package ru.job4j.io;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchRegExp implements SearchMethod {
    private Pattern pattern;

    public SearchRegExp(String searchString) {
        pattern = Pattern.compile(searchString);
    }

    @Override
    public Predicate<Path> searchBy() {
        return path -> {
            String filename = path.getFileName().toString();
            Matcher m = pattern.matcher(filename);
            return m.matches();
        };
    }
}
