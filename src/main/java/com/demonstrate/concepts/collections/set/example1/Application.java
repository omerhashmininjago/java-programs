package com.demonstrate.concepts.collections.set.example1;

import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

        Set<Employee> employeeSet = new HashSet<>();

        Employee one = new Employee("Omer");
        Employee two = new Employee("Hashmi");

        employeeSet.add(one);
        employeeSet.add(two);

        System.out.println(employeeSet.size());
    }
}
