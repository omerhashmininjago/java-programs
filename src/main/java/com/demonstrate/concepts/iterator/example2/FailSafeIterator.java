package com.demonstrate.concepts.iterator.example2;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Demonstrating fail safe iterator working on a concurrent collection
 */
public class FailSafeIterator {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("First", 10);
        map.put("Second", 20);
        map.put("Third", 30);
        map.put("Fourth", 40);

        Iterator<String> iterator = map.keySet().iterator();

        // this will not throw CME as here the collection would actually work on a clone of the collection
        // rather than the actual collection
        while (iterator.hasNext()) {
            iterator.next();
            map.put("Fifth", 50);
        }
    }
}
