package com.demonstrate.concepts.enumerations.example3;

import static com.demonstrate.concepts.enumerations.example3.VehicleFactory.SCOOTER;
import static com.demonstrate.concepts.enumerations.example3.VehicleFactory.TRUCK;

/**
 * Here we are demonstrating how a Enum can be used as a Factory pattern
 * <p>
 * Using Enum as factory removes unnecessary if conditions and switch statements
 */

public class Application {

    public static void main(String[] args) throws Exception {

        Vehicle car = VehicleFactory.getVehicleInstance("car  ");
        car.accelerate();
        car.applyBrakes();
        car.fillGasTank();

        Vehicle truck = VehicleFactory.getVehicleInstance(TRUCK);
        truck.fillGasTank();
        truck.startEngines();
        truck.accelerate();

        Vehicle scooter = VehicleFactory.getVehicleInstance(SCOOTER);
        scooter.stopEngine();
        scooter.fillGasTank();
    }
}
