package com.demonstrate.concepts.enumerations.example3;

import java.util.function.Supplier;

public final class SupplierUtil {

    public static final Supplier<Car> CAR_SUPPLIER = Car::new;
    public static final Supplier<Scooter> SCOOTER_SUPPLIER = Scooter::new;
    public static final Supplier<Truck> TRUCK_SUPPLIER = Truck::new;
}
