package com.demonstrate.concepts.enumerations.example3;

import static com.demonstrate.concepts.enumerations.example3.CrudeOil.getCrudeOilType;

public class Truck implements Vehicle {

    @Override
    public void startEngines() {
        System.out.println("Truck engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Truck engine stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Truck accelerating");
    }

    @Override
    public void applyBrakes() {
        System.out.println("Truck stops");
    }

    @Override
    public void fillGasTank() throws Exception {
        System.out.println("Car gas tank filled with " + getCrudeOilType("diesel"));
    }
}
