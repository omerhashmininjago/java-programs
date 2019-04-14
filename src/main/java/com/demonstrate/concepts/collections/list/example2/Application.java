package com.demonstrate.concepts.collections.list.example2;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List list = new ArrayList<>();

        list.add(new Boolean("ABC"));
        list.add(new Boolean("TRUE"));
        list.add(new Boolean(""));

        // Yes, Boolean has two constructors
        // 1. First takes in a boolean parameter
        // 2. Second takes in a String
        // where the String has any value equal ignore case to true, is considered as true
        // else false

        System.out.println(list.toString());
        // output here would be [false, true, false]
    }
}
