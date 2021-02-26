package ru.job4j.io;

import java.nio.file.Path;
import java.util.function.Predicate;

public class SearchFileName implements SearchMethod {
    private String fileName;

    public SearchFileName(String searchString) {
        this.fileName = searchString;
    }

    @Override
    public Predicate<Path> searchBy() {
        return p -> p.getFileName().toString().equals(fileName);
    }
}
