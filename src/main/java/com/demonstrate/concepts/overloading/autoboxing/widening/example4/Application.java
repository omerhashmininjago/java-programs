package com.demonstrate.concepts.overloading.autoboxing.widening.example4;

public class Application {

    public static void main(String[] args) {

        Conversion conversion = new Conversion();

        //There are not method overloaded with below Wrapper data types
        //But there do exists method with their corresponding primitive data types
        //But they wont be be called either as we have a method with Number as data type
        //And Number is parent class for all the below Wrapper classes
        conversion.convert(new Long(99));
        conversion.convert(new Integer(99));
        conversion.convert(new Float(99));
    }
}
