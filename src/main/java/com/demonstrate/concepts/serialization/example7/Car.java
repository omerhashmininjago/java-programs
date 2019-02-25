package com.demonstrate.concepts.serialization.example7;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {

    private static final long serialVersionUID = 666666666l;

    public Car(int wheels, String color) {
        super(wheels, color);
    }

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("companyName='").append(companyName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
