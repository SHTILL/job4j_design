package ru.job4j.io;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchExtension implements SearchMethod {
    private String extension;

    public SearchExtension(String searchString) {
        Pattern extPattern = Pattern.compile("^\\*\\.\\S*$");
        Matcher m = extPattern.matcher(searchString);
        if (m.matches()) {
            String[] tokens = searchString.split(".", 2);
            this.extension = tokens[1];
        } else {
            throw new UnsupportedOperationException("Incorrect mask format");
        }
    }


    @Override
    public Predicate<Path> searchBy() {
        return p -> p.getFileName().toString().endsWith(extension);
    }
}
