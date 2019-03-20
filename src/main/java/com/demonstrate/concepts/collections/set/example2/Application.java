package com.demonstrate.concepts.collections.set.example2;

import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

        Set<Employee> employeeSet = new HashSet<>();

        Employee one = new Employee("Omer");
        Employee two = new Employee("Hashmi");
        Employee three = new Employee("Remo");

        employeeSet.add(one);
        employeeSet.add(two);
        employeeSet.add(three);

        System.out.println(employeeSet.size());
        employeeSet.forEach(employee -> System.out.println(employee));
    }
}
