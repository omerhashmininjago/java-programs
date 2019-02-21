package com.demonstrate.concepts.collections.map.example2;

import java.util.HashMap;
import java.util.Map;

/**
 * HashCode in Name class is giving a random value
 *
 * Two same objects can go on different buckets
 */
public class Application {

    public static void main(String[] args) {

        Map<Name, Name> nameMap = new HashMap<>();

        Name nameOne = new Name("Omer", "Hashmi");
        Name nameTwo = new Name("Omer", "Hashmi");
        Name nameThree = new Name("Omer", "Shakir");

        System.out.println(nameOne.hashCode());
        System.out.println(nameTwo.hashCode());
        nameMap.put(nameOne, nameOne);
        nameMap.put(nameTwo, nameTwo);
        nameMap.put(nameThree, nameThree);

        System.out.println("Hashcode is corrupted " + nameMap.size());

    }
}
