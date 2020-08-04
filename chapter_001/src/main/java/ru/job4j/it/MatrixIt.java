package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = -1;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
        findNextRow(0);
    }

    private void findNextRow(int start) {
        row = -1;
        for (int i0 = start; i0 < data.length; i0++) {
            if (data[i0].length != 0) {
                row = i0;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        if (row == -1) {
            return false;
        }
        return data[row].length > column;
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
        findNextRow(++row);
        return rsl;
    }
}
