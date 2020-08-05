package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private int[] data;
    int position;

    public EvenIterator(final int[] numbers) {
        this.data = numbers;
        findNextElement(0);
    }

    private void findNextElement(int start) {
        for (position = start; position < data.length; position++) {
            if (data[position] % 2 == 0) {
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return position < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int rsl = data[position];
        findNextElement(++position);
        return rsl;
    }
}
