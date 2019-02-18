package com.demonstrate.concepts.serialization.example3;

import java.io.Serializable;

public class ParkingArea implements Serializable {

    private static final long serialVersionUID = 766666666l;

    // Serialization will fail as ParkingSlot does not implement Serializable
    // NonSerializationException will thrown identifying the victim class which caused it
    public ParkingSlot parkingSlot;

}
