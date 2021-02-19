package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T> implements Store<T> {
    List<T> store = new ArrayList<>();

    @Override
    public void add(T item) {
        store.add(item);
    }

    @Override
    public void remove(T item) {
        store.remove(item);
    }

    @Override
    public void archive() {
        throw new IllegalStateException("Don't know how to do it!!!");
    }
}
