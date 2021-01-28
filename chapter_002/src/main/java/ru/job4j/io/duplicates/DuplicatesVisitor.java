package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    HashMap<FileProperty, Path> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty p = new FileProperty(file.toFile().length(), file.toFile().getName());
        Path duplicate = files.get(p);
        if (duplicate != null) {
            System.out.printf("Files %s and %s are identical" + System.lineSeparator(), file.toAbsolutePath(), duplicate.toAbsolutePath());
        } else {
            files.put(p, file);
        }
        return super.visitFile(file, attrs);
    }
}
