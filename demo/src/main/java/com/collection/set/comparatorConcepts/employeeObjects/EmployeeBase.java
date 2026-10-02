package com.collection.set.comparatorConcepts.employeeObjects;

public class EmployeeBase implements Comparable<EmployeeBase> {

    String name;
    int empId;

    public EmployeeBase(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "EmployeeBase{name='" + name + "', empId=" + empId + "}";
    }

    @Override
    public int compareTo(EmployeeBase other) {
        return Integer.compare(this.empId, other.empId);
    }
}
