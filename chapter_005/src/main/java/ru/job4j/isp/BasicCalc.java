package ru.job4j.isp;

public class BasicCalc implements Calculator {
    @Override
    public int sum(int x1, int x2) {
        return x1 + x2;
    }

    @Override
    public int sub(int x1, int x2) {
        return x1 - x2;
    }

    @Override
    public long factorial(int x) {
        throw new IllegalStateException("Is not supported");
    }

    @Override
    public double root(int x) {
        throw new IllegalStateException("Is not supported");
    }
}
