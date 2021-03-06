package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    @Test
    public void whenGet () {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("zero");
        list.add("one");
        assertThat(list.get(0), is("zero"));
        assertThat(list.get(1), is("one"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNotExisted() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("zero");
        list.get(1);
    }

    @Test
    public void whenIterate() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("zero");
        list.add("one");
        Iterator<String> it = list.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is("zero"));
        assertTrue(it.hasNext());
        assertThat(it.next(), is("one"));
        assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextNotExisted() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("zero");
        list.add("one");
        Iterator<String> it = list.iterator();
        it.next();
        it.next();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddedWhileIterate() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("zero");
        list.add("one");
        Iterator<String> it = list.iterator();
        it.next();
        list.add("two");
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        SimpleLinkedList<Integer> linked = new SimpleLinkedList<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        SimpleLinkedList<Integer> linked = new SimpleLinkedList<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        SimpleLinkedList<Integer> linked = new SimpleLinkedList<>();
        linked.add(1);
        linked.add(2);
        linked.deleteFirst();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenDeleteLast() {
        SimpleLinkedList<Integer> linked = new SimpleLinkedList<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.deleteLast();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertFalse(it.hasNext());
    }

    @Test
    public void whenAddAndRevertThenIter() {
        SimpleLinkedList<Integer> linked = new SimpleLinkedList<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }
}