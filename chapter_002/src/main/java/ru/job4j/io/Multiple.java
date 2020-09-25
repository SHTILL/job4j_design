package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;

public class Multiple {
    public static void main(String[] args) {
        FileWriter fos = null;
        try {
            fos = new FileWriter("multiply_table.txt");
            fos.write("1*2=2" + System.lineSeparator());
            fos.write("1*3=3" + System.lineSeparator());
            fos.write("-----------" + System.lineSeparator());
            fos.write("1*9=9" + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
