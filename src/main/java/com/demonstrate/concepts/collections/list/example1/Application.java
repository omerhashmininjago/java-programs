package com.demonstrate.concepts.collections.list.example1;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List list = new ArrayList<>();

        list.add('A');
        list.add('B');
        list.add('C');

        // List has two overidden methods
        // 1. one takes an int as input and removes the object at the index
        // 2. second takes an object as input and removes it from the list
        // In this case, 'A' is converted to its equivalent int which is 65
        // which results in calling the overridden method which accepts int
        // and tries to remove the element at the 65th index
        // hence resulting in a RuntimeException
        list.remove('A');

        System.out.println(list.size());
        System.out.println(list.toString());
    }
}
