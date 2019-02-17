package com.demonstrate.concepts.overloading.example1;

public class Summation {

    public void sum(int a , int b) {
        int sum = a + b;
        System.out.println("sum(int, int) is " + sum);
    }

    public void sum(long a , long b) {
        long sum = a + b;
        System.out.println("sum(long, long) is " + sum);
    }

    public void sum(float a , float b) {
        float sum = a + b;
        System.out.println("sum(float, float) is " + sum);
    }

    public void sum(double a , double b) {
        double sum = a + b;
        System.out.println("sum(double, double) is " + sum);
    }

    public void sum(Integer a , Integer b) {
        Integer sum = a + b;
        System.out.println("sum(Integer, Integer) is " + sum);
    }

    public void sum(Number a , Number b) {
        Number sum = a.intValue() + b.intValue();
        System.out.println("sum(Number, Number) is " + sum);
    }
}
