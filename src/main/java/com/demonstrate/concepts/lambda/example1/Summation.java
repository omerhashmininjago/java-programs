package com.demonstrate.concepts.lambda.example1;

@FunctionalInterface
public interface Summation {

    int calculate(int a, int b);

    default void result(int a) {
        System.out.println("Sum is " + a);
    }

}
