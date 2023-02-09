package org.example.hw4;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TriangleS {
    public int formulaGerona(int a, int b, int c) throws MyException {

        if(a<0 || b<0 || c<0) throw new MyException("Стороны должны быть больше нуля");
        if (a + b < c || a + c < b || b + c < a) throw new MyException("Эти стороны не образуют треугольника");
        double p = (a + b + c) / 2.0;
        int result = (int) Math.round(sqrt(p * (p - a) * (p - b) * (p - c)));
        return result;
    }
}
