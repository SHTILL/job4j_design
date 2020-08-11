package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayIterator<E> implements Iterator<E> {
    private final int expectedModCount;
    private Object[] container;
    private SimpleArray<E> array;
    private int position;

    public SimpleArrayIterator(int expectedModCount, Object[] container, SimpleArray<E> array) {
        this.expectedModCount = expectedModCount;
        this.container = container;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return position < container.length;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (expectedModCount != array.getModCount()) {
            throw new ConcurrentModificationException();
        }
        return (E) container[position];
    }
}