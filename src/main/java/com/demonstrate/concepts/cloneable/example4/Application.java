package com.demonstrate.concepts.cloneable.example4;

import java.io.*;

/**
 * Demonstrating Deep Clone using Serialization
 *
 */
public class Application {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // (1) create a Person object named Al
        Address address = new Address("305 West Fern Avenue", "Palmer", "Alaska");
        Person al = new Person("Al", "Alexander", address);

        // (2) make a deep clone of Al
        Person neighbor = (Person) deepClone(al);

        // (3) modify the neighbor's attributes
        neighbor.firstName = "Martha";
        neighbor.lastName = "Stewart";

        // (4) show that it all worked
        System.out.print(neighbor);
    }

    /**
     * This method makes a "deep clone" of any object it is given.
     */
    public static Object deepClone(Object object) throws IOException, ClassNotFoundException {

            //Serialization process
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);

            //Deserialization process
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
    }
}
