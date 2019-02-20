package com.demonstrate.concepts.cloneable.example5;

import java.io.Serializable;

public class Car implements Serializable {
    private String carName;

    public Car(String name) {
        this.carName = name;
    }

    public String getCarName() {
        return carName;
    }
}