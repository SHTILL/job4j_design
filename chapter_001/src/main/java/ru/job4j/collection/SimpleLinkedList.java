package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements Iterable<E> {
    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    private Node<E> head;
    private int modCon;
    private int size;

    private Node<E> findTail(Node<E> start) {
        Node<E> cur = start;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private Node<E> getNodeByIndex(int index) {
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void add(E value) {
        Node<E> node = new Node<>(value, null);
        if (head == null) {
            head = node;
        } else {
            Node<E> tail = findTail(head);
            tail.next = node;
        }
        modCon++;
        size++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).item;
    }

    class SimpleLinkedListIterator<T> implements Iterator<T> {
        private int size;
        private final int expectedModCount;
        private Node<T> cursor;

        public SimpleLinkedListIterator(Node<T> head, int expectedModCount) {
            this.expectedModCount = expectedModCount;
            this.cursor = head;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            if (expectedModCount != modCon) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<T> tmp = cursor;
            cursor = cursor.next;

            return tmp.item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<>(head, modCon);
    }
}
