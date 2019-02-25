package com.demonstrate.concepts.serialization.example7;

import java.io.*;

/**
 * Deserialization will fail because Car parent Vehicle does not implement Serializable
 * It is a rule that the first Non Serializable should have a no-args Constructor accessible to the subclass
 * Reason for this is, the visible fields of parent class are initialized using this constructor
 */
public class Application {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Vehicle car = new Car(4, "Green");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(car);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        objectInputStream.readObject();

        System.out.println(car.getColor());

    }
}
