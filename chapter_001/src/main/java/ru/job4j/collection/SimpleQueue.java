package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T item = null;
        try {
            item = out.pop();
        } catch (NoSuchElementException e1) {
            while (true) {
                try {
                    out.push(in.pop());
                } catch (NoSuchElementException e2) {
                    break;
                }
            }
            item = out.pop();
        }
        return item;
    }

    public void push(T value) {
        in.push(value);
    }
}
