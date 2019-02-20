package com.demonstrate.concepts.cloneable.example3;

public class Employee {

    private String employeeName;
    private int employeeId;
    private Address address;


    public Employee() {
    }

    // Parameterized constructor for creating the object
    public Employee(String employeeName, int employeeId, Address address) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.address = address;
    }

    // Copy Constructor
    public Employee(Employee original) {
        this.employeeName = new String(original.employeeName);
        this.employeeId = original.getEmployeeId() + 1;
        this.address = new Address(original.address);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
