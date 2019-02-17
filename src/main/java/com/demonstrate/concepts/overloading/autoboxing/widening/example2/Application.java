package com.demonstrate.concepts.overloading.autoboxing.widening.example2;

public class Application {

    public static void main(String[] args) {

        Conversion conversion = new Conversion();

        //the primitive data type matching method would be called
        conversion.convert(100);
        //the Wrapper data type matching would be called
        conversion.convert(new Integer(99));
        //As the wrapper data type matching method is missing,
        // then the corresponding primitive data type method would be called
        // in this case that is also missing, then the next wider primitive data type method would be called i.e. float
        conversion.convert(new Long(2));

    }
}
