package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {
    @Test
    public void whenAdd() {
        SimpleMap<String, String> m = new SimpleMap<>();
        m.insert("one", "1");
        m.insert("two", "2");
        assertThat(m.get("two"), is("2"));
    }

    @Test
    public void whenDelete() {
        SimpleMap<String, String> m = new SimpleMap<>();
        m.insert("one", "1");
        m.insert("two", "2");
        m.delete("two");
        assertNull(m.get("two"));
    }

    @Test
    public void whenIterate() {
        SimpleMap<String, String> m = new SimpleMap<>();
        m.insert("one", "1");
        m.insert("two", "2");
        Iterator<Map.Entry<String, String>> it = m.iterator();
        assertThat(it.next(), anyOf(is(new SimpleMap.Node<String, String>("one", "1")), is(new SimpleMap.Node<String, String>("two", "2"))));
        assertThat(it.next(), anyOf(is(new SimpleMap.Node<String, String>("one", "1")), is(new SimpleMap.Node<String, String>("two", "2"))));
    }
}