package com.demonstrate.concepts.cloneable.example2;

public class Employee implements Cloneable {

    private String employeeName;
    private int employeeId;
    private Address address;

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

    /**
     * DeepCopy demonstration
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee employee = (Employee) super.clone();
        employee.setAddress((Address) employee.getAddress().clone()); // Here we are making a deep copy of Address
        return employee;
    }
}
