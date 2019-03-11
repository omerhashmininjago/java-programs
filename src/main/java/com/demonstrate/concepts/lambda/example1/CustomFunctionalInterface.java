package com.demonstrate.concepts.lambda.example1;

public class CustomFunctionalInterface {

    public static void main(String[] args) {

        Summation summation = (a, b) -> a + b;
        summation.result(summation.calculate(1, 7));
    }
}
