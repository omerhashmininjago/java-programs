package com.demonstrate.concepts.overloading.autoboxing.widening.example4;

public class Conversion {

    //Primitive argument - int
    public void convert(int number) {
        System.out.println("Primitive argument :: int :: " + number);
    }

    //Primitive argument - long
    public void convert(long number) {
        System.out.println("Primitive argument :: long :: " + number);
    }

    //Primitive argument - float
    public void convert(float number) {
        System.out.println("Primitive argument :: float :: " + number);
    }

    //Reference(Wrapper class) argument - Long
    public void convert(Number number) {
        System.out.println("Reference(Wrapper) argument :: Number :: " + number);
    }


}
