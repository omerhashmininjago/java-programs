package com.demonstrate.concepts.collections.iterator.example3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Demonstrating how an Iterator fails fast when working on a non concurrent collection
 * <p>
 * Fail Fast iterators only fail when elements are either added or removed, not modified
 */
public class FailFastIterators {

    public static void main(String[] args) {

        iterateOverArrayList();
        iterateOverHashMap();
    }

    private static void iterateOverHashMap() {
        Map<String, String> stringMap = new HashMap<>();

        stringMap.put("1", "Cricket");
        stringMap.put("2", "Football");
        stringMap.put("3", "BasketBall");

        Iterator<Map.Entry<String, String>> stringIterator = stringMap.entrySet().iterator();

        while (stringIterator.hasNext()) {
            if (stringIterator.next().getKey().equals("2")) {
                // This will not throw a CME as we are only modifying an already existing element in the Collection
                // The modCount internally used by the collection only changes when we are
                // adding a new Entry object or removing an existing entry object
                stringMap.put("2", "VolleyBall");
            }

        }
    }

    private static void iterateOverArrayList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() == 4) {
                // This will not throw a CME as we are only modifying an already existing element in the Collection
                // The modCount internally used by the collection only changes when we are
                // adding a new object or removing an existing object
                numbers.set(2, 7);
            }
        }
    }
}
