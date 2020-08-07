package ru.job4j.gen;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static java.lang.Integer.min;

public class SimpleArrayIterator<T> implements Iterator<T> {
    private T[] data;
    private int point = 0;
    private final int size;

    public SimpleArrayIterator(T[] data, int size) {
        this.data = data;
        this.size = min(size, data.length);
    }

    @Override
    public boolean hasNext() {
        return point < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
