package ru.job4j.io;

import org.apache.commons.cli.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {
    Options options = new Options();
    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();

    public List<Path> searchRegExp(Path root, Pattern pattern) throws IOException {
        Predicate<Path> findByRegExp = path -> {
            String filename = path.getFileName().toString();
            Matcher m = pattern.matcher(filename);
            return m.matches();
        };

        SearchFiles searcher = new SearchFiles(findByRegExp);
        Files.walkFileTree(root, searcher);

        return searcher.getPaths();
    }

    public List<Path> searchFile(Path root, String filename) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.getFileName().toString().equals(filename));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public List<Path> searchExtension(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.getFileName().toString().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
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

        List<Path> foundFiles = null;
        Path dir = Paths.get(line.getOptionValue("d"));
        String searchString = line.getOptionValue("n");
        String searchType = line.getOptionValue("t");
        switch (searchType) {
            case "reg":
                Pattern pattern = Pattern.compile(searchString);
                foundFiles = this.searchRegExp(dir, pattern);
                break;
            case "mask":
                Pattern extPattern = Pattern.compile("^\\*\\.\\S*$");
                Matcher m = extPattern.matcher(searchString);
                if (m.matches()) {
                    String[] tokens = searchString.split(".", 2);
                    foundFiles = searchExtension(dir, tokens[1]);
                }
                break;
            case "name":
                foundFiles = this.searchFile(dir, searchString);
                break;
            default:
                break;
        }

        if (foundFiles == null) {
            return false;
        }

        try (Writer w = new FileWriter(line.getOptionValue("o"))) {
            for (Path p : foundFiles) {
                w.write(p.toString() + System.lineSeparator());
            }
        }
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