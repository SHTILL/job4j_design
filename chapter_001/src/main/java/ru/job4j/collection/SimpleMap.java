package ru.job4j.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private static final int INITIAL_TABLE_SIZE = 16;
    private Object[] table = new Object[INITIAL_TABLE_SIZE];
    private int length = INITIAL_TABLE_SIZE;
    private int size;

    static class Node<K, V> implements Map.Entry<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<V, K> node = (Node) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    boolean insert(K key, V value) {
        int index = key.hashCode() & (length - 1);
        if (table[index] == null || table[index].equals(key)) {
            table[index] = new Node(key, value);
        } else {
            return false;
        }
        size++;
        return true;
    }

    V get(K key) {
        int index = key.hashCode() & (length - 1);
        Node n = (Node) table[index];
        return n == null ? null : (V) n.value;
    }

    boolean delete(K key) {
        int index = key.hashCode() & (length - 1);
        if (((Node) table[index]).key.equals(key)) {
            table[index] = null;
            return true;
        }
        return false;
    }

    private class MapIterator<E> implements Iterator<E> {
        int position;
        int sizeIterator;

        @Override
        public boolean hasNext() {
            return sizeIterator < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            for (; position < length; position++) {
                Node n = (Node) table[position];
                if (n != null) {
                    sizeIterator++;
                    return (E) n;
                }
            }
            return null;
        }
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MapIterator<>();
    }
}
