package com.demonstrate.concepts.overloading.autoboxing.widening.example1;

public class Conversion {

    //Primitive argument - int
    public void convert(int number) {
        System.out.println("Primitive argument :: int :: " + number);
    }

    //Reference(Wrapper class) argument - Integer
    public void convert(Integer number) {
        System.out.println("Reference(Wrapper) argument :: Integer :: " + number);
    }

    //Primitive argument - int
    public void convert(long number) {
        System.out.println("Primitive argument :: long :: " + number);
    }

}
