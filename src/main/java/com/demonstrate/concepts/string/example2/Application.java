package com.demonstrate.concepts.string.example2;

public class Application {

    public static void main(String[] args) {

        String str = "ABC";
        String heapStr = new String("ABC");
        // StringBuilder does not override equals method
        StringBuilder stringBuilder = new StringBuilder("ABC");
        // StringBuffer overrides the equals method and checks this == obj i.e. the reference
        StringBuffer stringBuffer = new StringBuffer("ABC");

        // Note :: String builder and String buffer cannot be used with == operator
        // Compile time exception will be thrown

        if (str.equals(heapStr)) {
            System.out.println("str equals headStr");
        }
        if (str.equals(stringBuilder)) {
            System.out.println("str equals stringBuilder");
        }
        if (str.equals(stringBuffer)) {
            System.out.println("str equals stringBuffer");
        }
        if (heapStr.equals(stringBuilder)) {
            System.out.println("heapStr equals stringBuilder");
        }
        if (heapStr.equals(stringBuffer)) {
            System.out.println("heapStr equals stringBuffer");
        }
        if (stringBuffer.equals(stringBuilder)) {
            System.out.println("stringBuffer equals stringBuilder");
        }

        if (str.equals(stringBuilder.toString())) {
            System.out.println("str equals stringBuilder toString");
        }
        if (str.equals(stringBuffer.toString())) {
            System.out.println("str equals stringBuffer toString");
        }
        if (heapStr.equals(stringBuilder.toString())) {
            System.out.println("heapStr equals stringBuilder toString");
        }
        if (heapStr.equals(stringBuffer.toString())) {
            System.out.println("heapStr equals stringBuffer toString");
        }
        if (stringBuffer.toString().equals(stringBuilder.toString())) {
            System.out.println("stringBuffer toString equals stringBuilder toString");
        }

    }
}
