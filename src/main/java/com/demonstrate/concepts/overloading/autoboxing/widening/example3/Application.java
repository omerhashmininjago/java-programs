package com.demonstrate.concepts.overloading.autoboxing.widening.example3;

public class Application {

    public static void main(String[] args) {

        Conversion conversion = new Conversion();

        //the closest primitive data type matching method would be called
        //as int was not available long was called
        conversion.convert(100);
        //the Wrapper data type matching would be called
        //As a method with Integer as Data type was not present it searches for corresponding primitive data type
        //As that was also not present it goes for the wider primitive data type(not wider Wrapper data type)
        conversion.convert(new Integer(99));
    }
}
