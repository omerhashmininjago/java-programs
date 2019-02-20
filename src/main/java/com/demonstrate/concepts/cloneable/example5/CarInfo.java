package com.demonstrate.concepts.cloneable.example5;

import java.io.Serializable;

public class CarInfo implements Serializable {
    private int id;
    private Car car;

    public CarInfo(int id, Car car) {
        this.id = id;
        this.car = car;
    }

    void setCar(Car car) {
        this.car = car;
    }

    void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public int getId() {
        return id;
    }
}