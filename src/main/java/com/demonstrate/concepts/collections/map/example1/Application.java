package com.demonstrate.concepts.collections.map.example1;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        String one = "test";
        String two = new String("test");
        String three = new String("test");

        Map<String, String> stringMap = new HashMap<>();

        stringMap.put(one, one);
        stringMap.put(two, two);
        stringMap.put(three, three);

        // Just demonstrating the fact that what ever the memory location of the instance be
        // It all depends on the identity + equality of the instance
        System.out.println(stringMap.size());


        Map<Name, Name> nameMap = new HashMap<>();

        Name nameOne = new Name("Omer", "Hashmi");
        Name nameTwo = new Name("Omer", "Hashmi");
        Name nameThree = new Name("Omer", "Shakir");

        nameMap.put(nameOne, nameOne);
        nameMap.put(nameTwo, nameTwo);
        nameMap.put(nameThree, nameThree);

        System.out.println(nameMap.size());

        if (nameOne != nameTwo) System.out.println("nameOne and nameTWo Memory locations are different");
        if (nameOne.equals(nameTwo))
            System.out.println("nameOne and nameTwo are Equal wrt content - this is what matters in HashMap");
    }
}
