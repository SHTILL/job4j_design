package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAdd() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("one");
        set.add("two");
        for (String item: set) {
            assertTrue(item.equals("one") || item.equals("two"));
        }
    }

    @Test
    public void whenContainsDuplicates() {
        SimpleSet<String> set = new SimpleSet<>();
        assertTrue(set.add("one"));
        assertFalse(set.add("one"));
        assertThat(set.size(), is(1));
    }
}