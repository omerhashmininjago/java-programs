package com.demonstrate.concepts.serialization.example6;

import java.io.*;

/**
 * Deserialization will fail if we have a parameterized Constructor
 * The default constructor of car will not be visible in this case
 */
public class Application {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Car car = new Car("Toyota");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(car);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        objectInputStream.readObject();

    }
}
