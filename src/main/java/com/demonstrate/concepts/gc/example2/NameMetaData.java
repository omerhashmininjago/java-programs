package com.demonstrate.concepts.gc.example2;

public class NameMetaData {

    private final String initials;

    public NameMetaData(Name name) {
        this.initials = name.getFirstName().substring(0, 1) + name.getLastName().substring(0, 1);
    }

    public String getInitials() {
        return initials;
    }
}
