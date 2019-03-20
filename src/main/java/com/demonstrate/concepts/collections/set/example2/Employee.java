package com.demonstrate.concepts.collections.set.example2;

import java.util.Objects;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
       return true;
    }

    @Override
    public int hashCode() {
        return this.name.length();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
