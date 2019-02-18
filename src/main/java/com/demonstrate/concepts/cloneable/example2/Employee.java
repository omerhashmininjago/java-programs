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
     * Clone of Employee will have a replica of Address (not same reference)
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee employee = (Employee) super.clone();
        Address address = new Address();
        address.setTown(employee.getAddress().getTown());
        employee.setAddress(address);
        return employee;
    }
}
