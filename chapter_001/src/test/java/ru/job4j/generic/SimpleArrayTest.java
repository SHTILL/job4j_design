package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenOverflow() {
        SimpleArray<Integer> a= new SimpleArray<>(10);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
    }

    @Test
    public void whenGet() {
        SimpleArray<Integer> a= new SimpleArray<>(10);
        a.add(1);
        assertThat(a.get(0), is(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNotPresent() {
        SimpleArray<Integer> a= new SimpleArray<>(10);
        a.add(1);
        a.get(1);
    }

    @Test
    public void whenRemove() {
        SimpleArray<Integer> a= new SimpleArray<>(10);
        a.add(1);
        a.add(2);
        a.remove(0);
        assertThat(a.get(0), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveLast() {
        SimpleArray<Integer> a= new SimpleArray<>(10);
        a.add(1);
        a.remove(0);
        a.get(0);
    }

    @Test
    public void whenSet() {
        SimpleArray<Integer> a= new SimpleArray<>(10);
        a.add(1);
        a.set(0, 2);
        assertThat(a.get(0), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetNotPresent() {
        SimpleArray<Integer> a= new SimpleArray<>(10);
        a.add(1);
        a.set(1, 2);
    }

    public void whenIterate() {
        SimpleArray<Integer> a= new SimpleArray<>(10);
        a.add(1);
        Iterator<Integer> it = a.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is(1));
        assertFalse(it.hasNext());
    }
}