package com.demonstrate.concepts.cloneable.example2;

/**
 * Deep Copy demonstration using Object.clone()
 *
 * 1. implementing Cloneable interface in the Class in question and in all references
 * 2. Overriding the clone method in the Class in question and in all references
 *
 */
public class Application {

    public static void main(String[] args) throws CloneNotSupportedException {


        Employee employee = new Employee();

        employee.setEmployeeId(123123);
        employee.setEmployeeName("Manhoar");

        Address address = new Address();
        address.setTown("Pune");

        employee.setAddress(address);

        Employee clone = (Employee) employee.clone();

        if (employee.getAddress() == clone.getAddress()) {
            System.out.println("Address is the same reference");
        } else System.out.println("Address has different reference");

        if (employee.getAddress().equals(clone.getAddress())) {
            System.out.println("Address is same object");
        } else System.out.println("Address is different object");

        if (employee == clone) {
            System.out.println("Employee has same reference");
        } else System.out.println("Employee has different reference");

    }
}
