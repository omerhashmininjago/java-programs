package com.demonstrate.concepts.collections.set.example1;

import java.util.Objects;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
