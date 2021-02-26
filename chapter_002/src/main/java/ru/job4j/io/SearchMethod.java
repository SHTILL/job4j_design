package ru.job4j.io;

import java.nio.file.Path;
import java.util.function.Predicate;

public interface SearchMethod {
    Predicate<Path> searchBy();
}