package com.demonstrate.concepts.overloading.example1;

public class Concatenation {

    public void concatenate(String a, String b) {
        String c = a + b;
        System.out.println("concatenate(String, String) = " + c);
    }

    public void concatenate(String args[]) {
        String c = args[0] + args[1];
        System.out.println("concatenate(String[]) = " + c);
    }

    public void concatenate(Object a, Object b) {
        String c = a.toString() + b.toString();
        System.out.println("concatenate(Object, Object) = " + c);
    }
}
