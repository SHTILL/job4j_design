package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T item = null;
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                    out.push(in.pop());
            }
        }
        item = out.pop();
        return item;
    }

    public void push(T value) {
        in.push(value);
    }
}
