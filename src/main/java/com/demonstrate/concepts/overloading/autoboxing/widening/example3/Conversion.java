package com.demonstrate.concepts.overloading.autoboxing.widening.example3;

public class Conversion {

    //Primitive argument - float
    public void convert(long number) {
        System.out.println("Primitive argument :: long :: " + number);
    }

    //Reference(Wrapper class) argument - Long
    public void convert(Long number) {
        System.out.println("Reference(Wrapper) argument :: Long :: " + number);
    }

}
