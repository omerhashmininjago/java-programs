package com.demonstrate.concepts.enumerations.example2;

/**
 * Here we are demonstrating how we can use Enums as Singletons
 * <p>
 * Enums are the best way to create Singletons
 */

public enum Calculations {

    CALCULATOR;

    public void sum(int a, int b) {
        System.out.println(a + b);
    }

    public void diff(int a, int b) {
        System.out.println(a - b);
    }

    public void multiply(int a, int b) {
        System.out.println(a * b);
    }

    public void remainder(int a, int b) {
        System.out.println(a % b);
    }

}
