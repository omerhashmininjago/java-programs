package com.demonstrate.concepts.collections.iterator.example1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstrating how an Iterator fails fast when working on a non concurrent collection
 */
public class FailFastIterators {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        // this will work fine as the remove method belongs to iterator
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 30) {
                iterator.remove(); // ok!
            }
        }

        // This will throw CME as we are removing an element from the actual collection
        iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 40) {
                numbers.remove(2); // exception
            }
        }
    }
}
