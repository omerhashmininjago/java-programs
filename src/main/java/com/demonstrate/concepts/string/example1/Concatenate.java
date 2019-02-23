package com.demonstrate.concepts.string.example1;

public class Concatenate {
    public static void main(String[] xargs) {
        String str = "ABC";
        String[] arr = new String[1];
        arr[0] = str;
        System.out.println(str + "    " + arr[0]);
        concatenate(str, arr);
        System.out.println(str + "    " + arr[0]);
    }

    static void concatenate(String str, String[] arr) {
        str = str + arr[0];
        arr[0] = str;
        arr = new String[1];
        arr[0] = "";
    }
}
