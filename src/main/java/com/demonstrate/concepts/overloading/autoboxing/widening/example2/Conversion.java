package com.demonstrate.concepts.overloading.autoboxing.widening.example2;

public class Conversion {

    //Primitive argument - int
    public void convert(int number) {
        System.out.println("Primitive argument :: int :: " + number);
    }

    //Reference(Wrapper class) argument - Integer
    public void convert(Integer number) {
        System.out.println("Reference(Wrapper) argument :: Integer :: " + number);
    }

    //Primitive argument - float
    public void convert(float number) {
        System.out.println("Primitive argument :: float :: " + number);
    }

    //Reference(Wrapper class) argument - Double
    public void convert(Double number) {
        System.out.println("Reference(Wrapper) argument :: Double :: " + number);
    }

}
