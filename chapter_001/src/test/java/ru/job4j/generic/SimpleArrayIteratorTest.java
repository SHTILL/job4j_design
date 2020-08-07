package ru.job4j.generic;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayIteratorTest {
    @Test
    public void whenMultiCallhasNextThenTrue() {
        SimpleArrayIterator<Integer> it = new SimpleArrayIterator<>(new Integer[] {1, 2, 3}, 3);
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
    }

    @Test
    public void whenReadSequence() {
        SimpleArrayIterator<Integer> it = new SimpleArrayIterator<>(new Integer[] {1, 2, 3}, 3);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        SimpleArrayIterator<Integer> it = new SimpleArrayIterator<>(new Integer[] {}, 0);
        it.next();
    }
}