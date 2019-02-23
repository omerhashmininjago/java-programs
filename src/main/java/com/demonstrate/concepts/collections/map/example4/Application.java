package com.demonstrate.concepts.collections.map.example4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Application {

    public static void main(String[] args) {

        Name nameOne = new Name("Omer", "Hashmi");

        Map<String, Name> stringNameMap = new HashMap<>();
        Map<Name, String> nameStringMap = new HashMap<>();

        //Insert first element in Map<String, Name>
        stringNameMap.put("1", nameOne);
        //Insert first element in Map<Name, String>
        nameStringMap.put(nameOne, "1");
        nameOne.setFirstName("Basil");
        //Using the same keys to fetch the data from each map
        System.out.println(stringNameMap.get("1"));
        //Map internally stores the key and hash in fields which are final
        System.out.println(nameStringMap.get(nameOne));
    }
}
