package com.demonstrate.concepts.string.example3;

public class Application {

    public static void main(String[] args) {
        String s1 = "Omer";
        concat1(s1);  // s1 is not changed 
        System.out.println("String: " + s1);

        StringBuilder s2 = new StringBuilder("Omer");
        concat2(s2); // s2 is changed 
        System.out.println("StringBuilder: " + s2);

        StringBuffer s3 = new StringBuffer("Omer");
        concat3(s3); // s3 is changed 
        System.out.println("StringBuffer: " + s3);
    }

    public static void concat1(String s1) {
        s1 = s1 + "Hashmi";
    }

    public static void concat2(StringBuilder s2) {
        s2.append("Hashmi");
    }

    public static void concat3(StringBuffer s3) {
        s3.append("Hashmi");
    }
}
