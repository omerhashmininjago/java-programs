package com.demonstrate.concepts.collections.map.example3;

import com.demonstrate.concepts.collections.map.example3.Name;

import java.util.HashMap;
import java.util.Map;

/**
 * Equals method is corrupted as its always returning false
 * This will always add the same object onto the same bucket as the hashcode implementation is correct
 */
public class Application {

    public static void main(String[] args) {

        Map<Name, Name> nameMap = new HashMap<>();

        Name nameOne = new Name("Omer", "Hashmi");
        Name nameTwo = new Name("Omer", "Hashmi");
        Name nameThree = new Name("Omer", "Shakir");

        nameMap.put(nameOne, nameOne);
        nameMap.put(nameTwo, nameTwo);
        nameMap.put(nameThree, nameThree);

        System.out.println("Equals is corrupted " + nameMap.size());

    }
}
