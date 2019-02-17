package com.demonstrate.concepts.enumerations.example3;

import static com.demonstrate.concepts.enumerations.example3.CrudeOil.getCrudeOilType;

public class Scooter implements Vehicle {

    @Override
    public void startEngines() {
        System.out.println("Scooter engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Scooter engine stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Scooter accelerating");
    }

    @Override
    public void applyBrakes() {
        System.out.println("Scooter stops");
    }

    @Override
    public void fillGasTank() throws Exception {
        System.out.println("Scooter gas tank filled with " + getCrudeOilType("petrol"));
    }
}
