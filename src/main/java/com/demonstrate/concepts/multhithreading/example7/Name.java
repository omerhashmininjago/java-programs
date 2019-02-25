package com.demonstrate.concepts.multhithreading.example7;

import java.util.Collections;
import java.util.List;

/**
 * Immutable class
 */
public final class Name implements Comparable<Name> {
    private final String firstName, lastName;
    private final List<String> strings;

    public Name(String firstName, String lastName, List strings) {
        if (firstName == null || lastName == null) {
            // this check ensure that the Name objects are always well formed and none of its method will
            // ever throw a NPE
            throw new NullPointerException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.strings = strings;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getStrings() {
        return Collections.unmodifiableList(strings);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Name))
            return false;
        Name n = (Name) o;
        return n.firstName.equals(firstName) && n.lastName.equals(lastName);
    }

    public int hashCode() {
        return 31 * firstName.hashCode() + lastName.hashCode();
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