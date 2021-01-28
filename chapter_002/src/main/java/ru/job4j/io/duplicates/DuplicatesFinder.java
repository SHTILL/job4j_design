package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    private static void usage() {
        System.out.println("Usage: java -jar duplicatesFinder.jar directoryName");
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            usage();
            return;
        }
        Files.walkFileTree(Path.of(args[0]), new DuplicatesVisitor());
    }
}