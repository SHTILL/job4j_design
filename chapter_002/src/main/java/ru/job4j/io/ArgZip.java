package ru.job4j.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArgZip {
    private final ArgsName argsVal;

    public ArgZip(String[] args) {
        argsVal = ArgsName.of(args);
    }

    public boolean valid()  throws IllegalArgumentException {
        if (argsVal.get("o") == null || argsVal.get("e") == null) {
            return false;
        }
        File f = new File(argsVal.get("d"));
        return f.isDirectory();
    }

    public String directory() throws IllegalArgumentException {
        return argsVal.get("d");
    }

    public String exclude()  throws IllegalArgumentException {
        return argsVal.get("e");
    }

    public String output()  throws IllegalArgumentException {
        return argsVal.get("o");
    }
}
