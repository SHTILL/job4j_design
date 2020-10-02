package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analyze {
    public static void unavailable(String source, String target) {
        String s;
        List<String> unavailableTime = new ArrayList<>();
        String tmp = null;

        boolean wasDown = false;
        try (BufferedReader r = new BufferedReader(new FileReader(source))) {
            while (true) {
                s = r.readLine();
                if (s == null) {
                    break;
                }

                String[] tokens = s.split(" ", 2);
                String error = tokens[0];
                String time = tokens[1];

                if (error.equals("200") || error.equals("300")) {
                    if (wasDown) {
                        unavailableTime.add(tmp + time + ";" + System.lineSeparator());
                    }
                    wasDown = false;
                } else {
                    if (!wasDown) {
                        tmp = time + ";";
                    }
                    wasDown = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (wasDown) {
            unavailableTime.add(tmp + System.lineSeparator());
        }

        try (PrintWriter w = new PrintWriter(new FileOutputStream(target))) {
            unavailableTime.forEach(w::write);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Analyze.unavailable("./chapter_002/data/server.log", "./chapter_002/data/unavailable.csv");
    }
}