package com.demonstrate.concepts.multhithreading.example5;

/**
 * Comparable naturally orders the collection
 */
public class StaffName implements Comparable<StaffName> {
    private final String firstName, lastName;

    public StaffName(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            // this check ensure that the StaffName objects are always well formed and none of its method will
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
        if (!(o instanceof StaffName))
            return false;
        StaffName n = (StaffName) o;
        return n.firstName.equals(firstName) && n.lastName.equals(lastName);
    }

    public int hashCode() {
        return 31 * firstName.hashCode() + lastName.hashCode();
    }

    // To give us human readable form when printing the collection
    public String toString() {
        return firstName + " " + lastName;
    }

    public int compareTo(StaffName n) {
        int lastCmp = lastName.compareTo(n.lastName);
        return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
    }
}