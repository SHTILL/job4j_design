package ru.job4j.generic;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] data;
    private final int size;
    private int positionAdd = 0;

    public SimpleArray(int size) {
        this.size = size;
        data = new Object[size];
    }

    public void add(T model) {
        Objects.checkIndex(positionAdd, size);
        data[positionAdd] = model;
        positionAdd++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, positionAdd);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, positionAdd);
        System.arraycopy(data, (index + 1), data, index, (positionAdd - index - 1));
        positionAdd--;
        data[positionAdd] = null;
    }

    public T get(int index) {
        Objects.checkIndex(index, positionAdd);
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<>((T[]) data, positionAdd);
    }
}
