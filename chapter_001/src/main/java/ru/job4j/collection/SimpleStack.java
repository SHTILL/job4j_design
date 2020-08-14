package ru.job4j.collection;

public class SimpleStack<T> {
    private SimpleLinkedList<T> linked = new SimpleLinkedList<>();

    public T pop() {
        T item = null;
        for (T t : linked) {
            item = t;
        }
        linked.deleteLast();
        return item;
    }

    public void push(T value) {
        linked.add(value);
    }
}
