package com.demonstrate.concepts.cloneable.example4;

import java.io.Serializable;

class Address implements Serializable {
    String street, city, state;

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }
}