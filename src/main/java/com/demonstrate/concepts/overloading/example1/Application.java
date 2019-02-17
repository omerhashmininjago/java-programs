package com.demonstrate.concepts.overloading.example1;

public class Application {

    public static void main(String[] args) {

        Summation summation = new Summation();

        summation.sum(1, 3);
        summation.sum(150, 200);
        summation.sum(2146999999, 2146999999);
        summation.sum(1.5, 7.8988);
        summation.sum(198766887899.2112112, 1);

        Concatenation concatenation = new Concatenation();

        concatenation.concatenate("Hello ", "String");
        concatenation.concatenate("Hello ", "String[]");
        concatenation.concatenate("Hello ", "Object");

    }
}
