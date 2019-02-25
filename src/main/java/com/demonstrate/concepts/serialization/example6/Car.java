package com.demonstrate.concepts.serialization.example6;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 666666666l;

    private String companyName;

    public Car(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
