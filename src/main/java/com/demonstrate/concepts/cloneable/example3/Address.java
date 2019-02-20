package com.demonstrate.concepts.cloneable.example3;

public class Address {

    private String addressLine1;
    private String addressLine2;
    private String town;
    private String state;
    private String country;

    public Address() {
    }

    public Address(String addressLine1, String addressLine2, String town, String state, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.state = state;
        this.country = country;
    }

    public Address(Address original) {
        this.addressLine1 = original.addressLine1;
        this.addressLine2 = original.getAddressLine2();
        this.country = original.country;
        this.state = original.state;
        this.town = original.town;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
