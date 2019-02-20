package com.demonstrate.concepts.cloneable.example4;

import java.io.Serializable;

/**
 * These classes implement Serializable so we can write them out and
 * read them back in as a stream of bytes.
 */
class Person implements Serializable {
    String firstName, lastName;
    Address address;

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: " + firstName + "\n");
        sb.append("Last Name: " + lastName + "\n");
        sb.append("Street: " + address.street + "\n");
        return sb.toString();
    }
}
