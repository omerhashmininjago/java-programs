package com.demonstrate.concepts.serialization.example7;

public class Vehicle {

    private int wheels;
    private String color;

    public Vehicle(int wheels, String color) {
        this.wheels = wheels;
        this.color = color;
    }

    public Vehicle() {
    }

    public int getWheels() {
        return wheels;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vehicle{");
        sb.append("wheels=").append(wheels);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
