package com.demonstrate.concepts.collections.comparator.example1;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSortApp {

    private static final Comparator<Employee> SENIORITY_ORDER =
            (e1, e2) -> e2.getHireDate().compareTo(e1.getHireDate());

    private static final Comparator<Employee> AGE_ORDER = Comparator
            .comparing(Employee::getAge);

    public static void main(String[] args) {
        Employee employeeArray[] = {
                new Employee(new Name("John", "Smith"), 34, new Date(100, 10, 2)),
                new Employee(new Name("Karl", "Ng"), 48, new Date(112, 10, 2)),
                new Employee(new Name("Jeff", "Smith"), 21, new Date(87, 10, 2)),
                new Employee(new Name("Tom", "Rich"), 50, new Date(115, 10, 2)),
                new Employee(new Name("Tom", "Rich"), 50, new Date(115, 9, 2)),
                new Employee(new Name("Tom", "Rich"), 51, new Date(115, 10, 2)),
        };

        List<Employee> e = Arrays.asList(employeeArray);

        //Sorting only on based on Seniority in Firm
        Collections.sort(e, SENIORITY_ORDER);
        System.out.println(e);

        List<Employee> e2 = Arrays.asList(employeeArray);
        //Sorting first based on Seniority in Firm and then by Age
        List<Employee> e3 = e2.stream().sorted(SENIORITY_ORDER).sorted(AGE_ORDER).collect(Collectors.toList());
        System.out.println(e3);
    }
}
