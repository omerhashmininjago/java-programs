package com.demonstrate.concepts.collections.comparable.example1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NameSortApp {

    public static void main(String[] args) {

        Name nameArray[] = {
                new Name("John", "Smith"),
                new Name("Karl", "Ng"),
                new Name("Jeff", "Smith"),
                new Name("Tom", "Rich")
        };

        List<Name> names = Arrays.asList(nameArray);
        Collections.sort(names);
        System.out.println(names);

        //Sort in reverse natural order
        Collections.sort(names, Collections.reverseOrder());
        System.out.println(names);
    }
}
