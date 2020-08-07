package ru.job4j.generic;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    Object[] data;
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
        while (data[index] != null && index < (size - 1)) {
            data[index] = data[index + 1];
            index++;
        }
        data[index + 1] = null;
        positionAdd--;
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
