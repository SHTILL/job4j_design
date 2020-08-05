package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
        findNextRow();
    }

    private void findNextRow() {
        for (; row < data.length; row++) {
            if (data[row].length != 0) {
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return (row < data.length);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int rsl = data[row][column];

        if (column < (data[row].length - 1)) {
            column++;
            return rsl;
        }
        column = 0;
        row++;
        findNextRow();
        return rsl;
    }
}
