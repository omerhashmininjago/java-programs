package com.demonstrate.concepts.collections.comparator.example1;

import java.util.Date;
import java.util.Objects;

public final class Employee implements Comparable<Employee> {

    private final Name name;
    private final Integer age;
    private final Date hireDate;

    public Employee(Name name, int age, Date hireDate) {
        if (name == null || hireDate == null) {
            // this check ensure that the Employee objects are always well formed and none of its method will
            // ever throw an NPE
            throw new NullPointerException();
        }
        this.name = name;
        this.age = age;
        this.hireDate = hireDate;
    }

    // Employees Natural ordering is based on the Employees name
    public int compareTo(Employee employee) {
        int lastCmp = employee.getName().getLastName().compareTo(employee.getName().getLastName());
        return (lastCmp != 0 ? lastCmp : getName().getFirstName().compareTo(employee.getName().getFirstName()));
    }

    public Name getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Date getHireDate() {
        return hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                name.equals(employee.name) &&
                hireDate.equals(employee.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, hireDate);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", hireDate=").append(hireDate);
        sb.append('}');
        return sb.toString();
    }
}