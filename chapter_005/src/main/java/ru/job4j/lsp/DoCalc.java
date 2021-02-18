package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class DoCalc {
    public static void main(String[] args) {
        List<Num> numbers = new ArrayList<>();
        numbers.add(new Num(5));
        numbers.add(new IntNum(7));
        numbers.add(new Num(8));
        numbers.add(new IntNum(-9));

        for (Num n: numbers) {
            if (Double.isNaN(n.squareRoot())) {
                System.out.print("Invariants are broken. LSP is neglected!!!");
            }
        }
    }
}
