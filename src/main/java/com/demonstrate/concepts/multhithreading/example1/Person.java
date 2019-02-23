package com.demonstrate.concepts.multhithreading.example1;

public class Person {

    // Assigning the key to be handled at Class level

    // In case we have Threads accessing methods on different instances of Person
    // and we want to still restrict access to Race Conditions
    // Then attaining lock on this static variable would do the job
    private static final Object key = new Object();

    public void getAge() {

        synchronized (key) {

        }

    }

}
