package ru.job4j.isp;

import org.apache.commons.math3.util.CombinatoricsUtils;

public class AdvancedCalc implements Calculator {
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
        return CombinatoricsUtils.factorial(x);
    }

    @Override
    public double root(int x) {
        return Math.sqrt(x);
    }
}
