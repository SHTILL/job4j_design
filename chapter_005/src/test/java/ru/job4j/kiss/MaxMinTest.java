package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxMinTest {
    @Test
    public void whenMaxInteger() {
        List<Integer> l = new ArrayList<>(List.of(50, 35, 8));
        assertEquals( 50, MaxMin.max(l, Integer::compareTo).intValue());
    }

    @Test
    public void whenMinInteger() {
        List<Integer> l = new ArrayList<>(List.of(50, 35, 8));
        assertEquals(8, MaxMin.min(l, Integer::compareTo).intValue());
    }

    @Test
    public void whenMaxDouble() {
        List<Double> l = new ArrayList<>(List.of(50.2, 35.9, 8.2));
        assertEquals(50.2, MaxMin.max(l, Double::compareTo), 0.1);
    }

    @Test
    public void whenMinDouble() {
        List<Double> l = new ArrayList<>(List.of(50.2, 35.9, 8.2));
        assertEquals(8.2, MaxMin.min(l, Double::compareTo), 0.1);
    }
}