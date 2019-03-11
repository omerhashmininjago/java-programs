package com.demonstrate.concepts.streams.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    private static final Predicate<String> EQUALS_CHECK = String::isEmpty;

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add(null);
        strings.add("  ");

        long countOfEmptyStrings = strings.stream().filter(EQUALS_CHECK).count();
        System.out.println(countOfEmptyStrings);
    }

}
