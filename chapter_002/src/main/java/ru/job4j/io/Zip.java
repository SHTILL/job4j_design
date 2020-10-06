package ru.job4j.io;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path p: sources) {
                File source = p.toFile();
                zip.putNextEntry(new ZipEntry(source.getPath()));
                packSingleFile(p.toFile(), target);
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(in.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(in.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ArgZip zipArgs = new ArgZip(args);
        if (!zipArgs.valid()) {
            System.out.println("Invalid parameters");
            System.out.println("Usage:");
            System.out.println("java -jar pack.jar -d=DIR_NAME -e=EXCLUDE_EXTENSION -o=OUTPUT_FILE");
            throw new IllegalArgumentException();
        }

        SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(zipArgs.exclude()));
        Files.walkFileTree(Paths.get(zipArgs.directory()), searcher);

        Zip archive = new Zip();
        archive.packFiles(searcher.getPaths(), new File(zipArgs.output()));
    }
}
