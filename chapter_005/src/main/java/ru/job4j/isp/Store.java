package ru.job4j.isp;

public interface Store<T> {
    void add(T item);
    void remove(T item);
    void archive();
}
