package com.demonstrate.concepts.enumerations.example2;

import static com.demonstrate.concepts.enumerations.example2.Calculations.CALCULATOR;

/**
 * Here we are demonstrating how we can use Enums as Singletons
 * <p>
 * Enums are the best way to create Singletons
 */

public class Applications {

    public static void main(String[] args) {

        CALCULATOR.diff(4, 2);
        CALCULATOR.multiply(10, 7);
        CALCULATOR.sum(27, 2);
        CALCULATOR.remainder(6, 4);
    }
}
