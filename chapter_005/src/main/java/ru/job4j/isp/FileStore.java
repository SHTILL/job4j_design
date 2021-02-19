package ru.job4j.isp;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileStore implements Store<String> {
    private BufferedWriter w;
    private BufferedWriter a;

    private static final String TEXT_FILE = "/tmp/tmp_file.txt";
    private static final String ARC_FILE = "/tmp/tmp_file.zip";

    public FileStore() throws IOException {
        this.w = new BufferedWriter(new FileWriter(TEXT_FILE));
    }

    @Override
    public void add(String item) {
        try {
            w.append(item);
            w.flush();
        } catch (IOException e) {
            //swallow
        }
    }

    @Override
    public void remove(String item) {
        throw new IllegalStateException("Doesn't supported!!!");
    }

    @Override
    public void archive() {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(ARC_FILE)))) {
            zip.putNextEntry(new ZipEntry(TEXT_FILE));

            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(TEXT_FILE))) {
                zip.write(out.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Store<String> s = new FileStore();
        s.add("Privet");
        s.archive();
        while (true) {
            System.out.println("Sleep");
            Thread.sleep(1000);
        }
    }
}
