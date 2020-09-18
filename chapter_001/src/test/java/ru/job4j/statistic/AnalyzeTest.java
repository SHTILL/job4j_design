package ru.job4j.statistic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnalyzeTest {
    @Test
    public void whenAdded() {
        Analyze.User u1 = new Analyze.User();
        u1.name = "u1";
        u1.id = 1;
        List<Analyze.User> prev = new ArrayList<>();
        prev.add(u1);

        Analyze.User u2 = new Analyze.User();
        u1.name = "u2";
        u1.id = 2;
        List<Analyze.User> cur = new ArrayList<>();
        cur.add(u1);
        cur.add(u2);

        Analyze.Info inf = Analyze.diff(prev, cur);
        assertEquals(1, inf.added);
    }

    @Test
    public void whenChanged() {
        Analyze.User u1 = new Analyze.User();
        u1.name = "u1";
        u1.id = 1;
        List<Analyze.User> prev = new ArrayList<>();
        prev.add(u1);

        Analyze.User u2 = new Analyze.User();
        u2.name = "u2";
        u2.id = 1;
        List<Analyze.User> cur = new ArrayList<>();
        cur.add(u2);

        Analyze.Info inf = Analyze.diff(prev, cur);
        assertEquals(1, inf.changed);
    }

    @Test
    public void whenDeleted() {
        Analyze.User u1 = new Analyze.User();
        u1.name = "u1";
        u1.id = 1;

        Analyze.User u2 = new Analyze.User();
        u2.name = "u2";
        u2.id = 2;

        List<Analyze.User> prev = new ArrayList<>();
        prev.add(u1);
        prev.add(u2);

        List<Analyze.User> cur = new ArrayList<>();
        cur.add(u2);

        Analyze.Info inf = Analyze.diff(prev, cur);
        assertEquals(1, inf.deleted);
    }

    @Test
    public void whenAddedChangedDeleted() {
        Analyze.User u1 = new Analyze.User();
        u1.name = "u1";
        u1.id = 1;

        Analyze.User u2 = new Analyze.User();
        u2.name = "u2";
        u2.id = 1;

        Analyze.User u3 = new Analyze.User();
        u3.name = "u3";
        u3.id = 3;

        Analyze.User u4 = new Analyze.User();
        u4.name = "u4";
        u4.id = 4;

        List<Analyze.User> prev = new ArrayList<>();
        prev.add(u1);
        prev.add(u3);

        List<Analyze.User> cur = new ArrayList<>();
        cur.add(u2);
        cur.add(u4);

        Analyze.Info inf = Analyze.diff(prev, cur);
        assertEquals(1, inf.deleted);
        assertEquals(1, inf.changed);
        assertEquals(1, inf.added);
    }
}