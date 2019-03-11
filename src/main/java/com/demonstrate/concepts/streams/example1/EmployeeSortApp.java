package com.demonstrate.concepts.streams.example1;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeSortApp {

    private static final Comparator<Employee> SENIORITY_ORDER =
            (e1, e2) -> e2.getHireDate().compareTo(e1.getHireDate());

    // Prefer this way - the comparing method does a NotNull check and throws an NPE
    private static final Comparator<Employee> AGE_ORDER = Comparator
            .comparing(Employee::getAge);

    private static final Function<Employee, Integer> AGE = Employee::getAge;

    private static final Predicate<Employee> BELOW_40 = employee -> employee.getAge() < 40;

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
        sorting(employeeArray, e);
        distinct(e);
        limiting(e);
        maxAndMinAge(e);
        addAges(e);
        goupByName(e);

        groupByNameBelow40Years(e);
    }

    private static void groupByNameBelow40Years(List<Employee> e) {
        Map<Name, List<Employee>> result = e.stream().filter(BELOW_40).collect(Collectors.groupingBy(bean -> new Name(bean.getName().getFirstName(), bean.getName().getLastName())));
        System.out.println(result.entrySet());
    }

    private static void goupByName(List<Employee> e) {
        Map<Name, List<Employee>> result = e.stream().collect(Collectors.groupingBy(bean -> new Name(bean.getName().getFirstName(), bean.getName().getLastName())));
        System.out.println(result.entrySet());
    }

    private static void addAges(List<Employee> e) {
        Optional<Integer> sum = e.stream().map(AGE).reduce((Integer::sum));
        sum.ifPresent((age) -> System.out.println(age));
    }

    private static void maxAndMinAge(List<Employee> e) {
        Optional<Integer> maxAge = e.stream().map(AGE).reduce(BinaryOperator.maxBy(Integer::compareTo));
        maxAge.ifPresent((age) -> System.out.println(age));
        Optional<Integer> minAge = e.stream().map(AGE).reduce(BinaryOperator.minBy(Integer::compareTo));
        minAge.ifPresent((age) -> System.out.println(age));
    }

    private static void limiting(List<Employee> e) {
        List<Integer> limitingList = e.stream().map(AGE).limit(3).collect(Collectors.toList());
        System.out.println(limitingList);
    }

    private static void distinct(List<Employee> e) {
        List<Integer> ageList = e.stream().map(AGE).distinct().collect(Collectors.toList());
        System.out.println(ageList);
    }

    private static void sorting(Employee[] employeeArray, List<Employee> e) {
        //Sorting only on based on Seniority in Firm
        Collections.sort(e, SENIORITY_ORDER);
        System.out.println(e);

        List<Employee> e2 = Arrays.asList(employeeArray);
        //Sorting first based on Seniority in Firm and then by Age
        List<Employee> e3 = e2.stream().sorted(SENIORITY_ORDER.thenComparing(AGE_ORDER.reversed())).collect(Collectors.toList());
        System.out.println(e3);
    }
}
