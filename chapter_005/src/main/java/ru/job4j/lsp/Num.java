package ru.job4j.lsp;

public class Num {
    protected int num;

    public Num(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Illegal natural number!!!");
        }
        this.num = num;
    }

    public void setNum(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Illegal natural number!!!");
        }
        this.num = num;
    }

    public double squareRoot() {
        return Math.sqrt(num);
    }
}