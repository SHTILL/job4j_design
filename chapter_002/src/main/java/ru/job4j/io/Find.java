package ru.job4j.io;

import org.apache.commons.cli.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

public class Find {
    Options options = new Options();
    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();

    public List<Path> search(Path root, SearchMethod method) throws IOException {
        SearchFiles searcher = new SearchFiles(method.searchBy());
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public void saveResult(String fileName, Collection<Path> foundFiles) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(fileName))) {
            for (Path f : foundFiles) {
                w.write(f.toString());
                w.newLine();
            }
        }
    }

    public boolean menu(String[] args) throws IOException {
        Option dirOpt = Option.builder("d")
                .required(true)
                .hasArg()
                .argName("dir")
                .desc("directory for search")
                .build();

        Option outfileOpt = Option.builder("o")
                .required(true)
                .hasArg()
                .argName("file")
                .desc("output file for search")
                .build();

        Option fileNameOpt = Option.builder("n")
                .required(true)
                .hasArg()
                .argName("fileName")
                .desc("file name, mask or regexp for search")
                .build();

        Option searchTypeOpt = Option.builder("t")
                .required(true)
                .hasArg()
                .argName("searchType")
                .desc("search type: name, mask or reg")
                .build();

        options.addOption(dirOpt);
        options.addOption(outfileOpt);
        options.addOption(fileNameOpt);
        options.addOption(searchTypeOpt);

        CommandLine line;
        try {
            line = parser.parse(options, args);
        } catch (Exception e) {
            return false;
        }

        String searchType = line.getOptionValue("t");
        String searchString = line.getOptionValue("n");
        SearchMethod method = SearchFactory.getSearch(searchType, searchString);

        Path dir = Paths.get(line.getOptionValue("d"));
        List<Path> foundFiles = search(dir, method);
        if (foundFiles == null) {
            return false;
        }

        String outFile = line.getOptionValue("o");
        saveResult(outFile, foundFiles);
        return true;
    }

    public static void main(String[] args) {
        Find f = new Find();
        try {
            if (f.menu(args)) {
                System.out.println("Search is completed. Results are in log file!!!");
            } else {
                f.formatter.printHelp("java -jar find.jar [options]", f.options);
            }
        } catch (IOException e) {
            System.out.println("Search failed. Either directory for search is missing or outfile is inaccessible!!!");
        }
    }
}