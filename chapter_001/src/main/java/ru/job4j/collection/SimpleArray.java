package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private static final int EXTEND_BY = 10;
    private Object[] container = {};
    private int size;
    private int position;
    private int modCount;

    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) container[index];
    }

    public void add(T model) {
        if (position >= size) {
            size += EXTEND_BY;
            Object[] extended = new Object[size];
            System.arraycopy(container, 0, extended, 0, container.length);
            container = extended;
        }
        container[position] = model;
        position++;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<>(modCount, container, this);
    }

    public int getModCount() {
        return modCount;
    }
}
