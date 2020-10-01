package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalyzeTest {
    @Rule
    public TemporaryFolder f = new TemporaryFolder();

    @Test
    public void whenExample() throws IOException {
        String sourceFileName = "server.log";
        String targetFileName = "unavailable.csv";
        File source = f.newFile(sourceFileName);
        Writer w = new BufferedWriter(new FileWriter(source));
        w.write("200 10:56:01" + System.lineSeparator());
        w.write("500 10:57:01" + System.lineSeparator());
        w.write("400 10:58:01" + System.lineSeparator());
        w.write("200 10:59:01" + System.lineSeparator());
        w.write("500 11:01:02" + System.lineSeparator());
        w.write("200 11:02:02" + System.lineSeparator());
        w.close();

        File target = f.newFile(targetFileName);
        Analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        BufferedReader r = new BufferedReader(new FileReader(target));
        assertThat(r.readLine(), is("10:57:01;10:59:01;"));
        assertThat(r.readLine(), is("11:01:02;11:02:02;"));
        r.close();
    }

    @Test
    public void whenStartDown() throws IOException {
        String sourceFileName = "server.log";
        String targetFileName = "unavailable.csv";
        File source = f.newFile(sourceFileName);
        Writer w = new BufferedWriter(new FileWriter(source));
        w.write("500 10:57:01" + System.lineSeparator());
        w.write("200 10:58:01" + System.lineSeparator());
        w.close();

        File target = f.newFile(targetFileName);
        Analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        BufferedReader r = new BufferedReader(new FileReader(target));
        assertThat(r.readLine(), is("10:57:01;10:58:01;"));
        r.close();
    }

    @Test
    public void whenStartUp() throws IOException {
        String sourceFileName = "server.log";
        String targetFileName = "unavailable.csv";
        File source = f.newFile(sourceFileName);
        Writer w = new BufferedWriter(new FileWriter(source));
        w.write("300 10:20:01" + System.lineSeparator());
        w.write("500 10:57:01" + System.lineSeparator());
        w.write("200 10:58:01" + System.lineSeparator());
        w.close();

        File target = f.newFile(targetFileName);
        Analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        BufferedReader r = new BufferedReader(new FileReader(target));
        assertThat(r.readLine(), is("10:57:01;10:58:01;"));
        r.close();
    }

    @Test
    public void whenStillDown() throws IOException {
        String sourceFileName = "server.log";
        String targetFileName = "unavailable.csv";
        File source = f.newFile(sourceFileName);
        Writer w = new BufferedWriter(new FileWriter(source));
        w.write("300 10:20:01" + System.lineSeparator());
        w.write("500 10:57:01" + System.lineSeparator());
        w.close();

        File target = f.newFile(targetFileName);
        Analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        BufferedReader r = new BufferedReader(new FileReader(target));
        assertThat(r.readLine(), is("10:57:01;"));
        r.close();
    }
}