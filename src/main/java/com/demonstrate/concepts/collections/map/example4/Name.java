package com.demonstrate.concepts.collections.map.example4;

/**
 * Comparable naturally orders the collection
 */
public class Name implements Comparable<Name> {
    private String firstName, lastName;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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