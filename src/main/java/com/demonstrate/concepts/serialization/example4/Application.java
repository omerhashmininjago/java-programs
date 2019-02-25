package com.demonstrate.concepts.serialization.example4;

import java.io.*;

public class Application {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ParkingSlot parkingSlot = new ParkingSlot(2, "Car");
        ParkingArea parkingArea = new ParkingArea(3, parkingSlot);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(parkingArea);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        ParkingArea cloneParkingArea = (ParkingArea) objectInputStream.readObject();

        System.out.println(cloneParkingArea);
    }
}
