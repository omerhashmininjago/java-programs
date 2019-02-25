package com.demonstrate.concepts.serialization.example4;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 *  Below methods will allow you to handle Serialization the way you want it to
 *  Rather than the JVM handling it
 *
 *  Note - we would need to make sure that we use the exact same method signatures
 */
public class ParkingSlot implements Serializable  {

    private int slotNum;

    private String vehicleType;

    public ParkingSlot(int slotNum, String vehicleType) {
        this.slotNum = slotNum;
        this.vehicleType = vehicleType;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ParkingSlot{");
        sb.append("slotNum=").append(slotNum);
        sb.append(", vehicleType='").append(vehicleType).append('\'');
        sb.append('}');
        return sb.toString();
    }

    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {}

    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {

        // this will not allow Serialization of ParkingSlot to happen based - due to any business use case
        // Useful in cases when this Class is being used in a Has-A Relationship as a reference
        // The main class is Serializable and has not declared ParkingSlot as Transient, then this will
        // make sure that Serialization fails
        // and the main class will have to explicitly mention the Reference as Transient
        throw new NotSerializableException();
    }

}
