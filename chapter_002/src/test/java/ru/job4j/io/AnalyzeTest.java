package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalyzeTest {
    @Test
    public void whenExample() {
        String source = "./data/server.log";
        String target = "./data/unavailable.csv";
        Analyze.unavailable(source, target);
        try (BufferedReader r = new BufferedReader(new FileReader(target))) {
            assertThat(r.readLine(), is("10:57:01;10:59:01;"));
            assertThat(r.readLine(), is("11:01:02;11:02:02;"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenStartDown() {
        String source = "./data/server_start_down.log";
        String target = "./data/unavailable.csv";
        Analyze.unavailable(source, target);
        try (BufferedReader r = new BufferedReader(new FileReader(target))) {
            assertThat(r.readLine(), is("10:57:01;10:58:01;"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenStartUp() {
        String source = "./data/server_start_up.log";
        String target = "./data/unavailable.csv";
        Analyze.unavailable(source, target);
        try (BufferedReader r = new BufferedReader(new FileReader(target))) {
            assertThat(r.readLine(), is("10:57:01;10:58:01;"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenStillDown() {
        String source = "./data/server_still_down.log";
        String target = "./data/unavailable.csv";
        Analyze.unavailable(source, target);
        try (BufferedReader r = new BufferedReader(new FileReader(target))) {
            assertThat(r.readLine(), is("10:57:01;"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}