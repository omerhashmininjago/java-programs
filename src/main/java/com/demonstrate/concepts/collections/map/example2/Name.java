package com.demonstrate.concepts.collections.map.example2;

import java.util.Random;

/**
 * Comparable naturally orders the collection
 *
 */
public class Name implements Comparable<Name> {
    private final String firstName, lastName;

    public Name(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            // this check ensure that the Name objects are always well formed and none of its method will
            // ever throw a NPE
            throw new NullPointerException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Name))
            return false;
        Name n = (Name) o;
        return n.firstName.equals(firstName) && n.lastName.equals(lastName);
    }

    //Corrupt implementation of hashCode
    public int hashCode() {
        return (int) (Math.random() * 99);
    }

    // To give us human readable form when printing the collection
    public String toString() {
        return firstName + " " + lastName;
    }

    public int compareTo(Name n) {
        int lastCmp = lastName.compareTo(n.lastName);
        return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
    }
}