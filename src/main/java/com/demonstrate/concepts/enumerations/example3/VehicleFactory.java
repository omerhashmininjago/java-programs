package com.demonstrate.concepts.enumerations.example3;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.function.Supplier;

import static com.demonstrate.concepts.enumerations.example3.SupplierUtil.*;

/**
 * Here we are demonstrating how a Enum can be used as a Factory pattern
 * <p>
 * Using Enum as factory removes unnecessary if conditions and switch statements
 */
public enum VehicleFactory {

    CAR(CAR_SUPPLIER),
    SCOOTER(SCOOTER_SUPPLIER),
    TRUCK(TRUCK_SUPPLIER);

    private Supplier vehicle;

    VehicleFactory(Supplier vehicle) {
        this.vehicle = vehicle;
    }

    public static Vehicle getVehicleInstance(String vehicleInstance) throws Exception {
        if (StringUtils.isEmpty(vehicleInstance)) {
            throw new Exception("Input is null - Here is the list of valid Vehicles " + Arrays.toString(VehicleFactory.values()));
        }
        for (VehicleFactory type : VehicleFactory.values()) {
            if (vehicleInstance.trim().toUpperCase().equals(type.name())) {
                return (Vehicle) type.vehicle.get();
            }
        }
        throw new Exception("Invalid Vehicle - Here is the list of valid Vehicles " + Arrays.toString(VehicleFactory.values()));
    }

    public static Vehicle getVehicleInstance(VehicleFactory vehicleInstance) throws Exception {
        return (Vehicle) vehicleInstance.vehicle.get();
    }
}

