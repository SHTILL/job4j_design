package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> array = new SimpleArray<>();

    public boolean add(E e) {
        if (array.contains(e)) {
            return false;
        }
        return array.add(e);
    }

    public int size() {
        return array.size();
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
