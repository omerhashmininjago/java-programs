package com.demonstrate.concepts.serialization.example4;

import java.io.Serializable;

public class ParkingArea implements Serializable {

    private static final long serialVersionUID = 766666666l;

    private int floors;

    public ParkingArea(int floors, ParkingSlot parkingSlot) {
        this.floors = floors;
        this.parkingSlot = parkingSlot;
    }

    // Serialization will fail as ParkingSlot is blocking it self form being serialized
    // NotSerializationException will thrown identifying the victim class which caused it
    private ParkingSlot parkingSlot;

    public int getFloors() {
        return floors;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ParkingArea{");
        sb.append("floors=").append(floors);
        sb.append(", parkingSlot=").append(parkingSlot);
        sb.append('}');
        return sb.toString();
    }
}
