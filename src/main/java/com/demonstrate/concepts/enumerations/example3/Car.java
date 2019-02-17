package com.demonstrate.concepts.enumerations.example3;

import static com.demonstrate.concepts.enumerations.example3.CrudeOil.*;

public class Car implements Vehicle {

    @Override
    public void startEngines() {
        System.out.println("Car engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Car accelerating");
    }

    @Override
    public void applyBrakes() {
        System.out.println("Car stops");
    }

    @Override
    public void fillGasTank() throws Exception {
        System.out.println("Car gas tank filled with " + getCrudeOilType("gas"));
    }
}
