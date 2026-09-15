package com.collections.set.comparatorConcepts.employeeObjects;

public class employeeBase implements Comparable<employeeBase> {

    String name;
    int empId;

    public employeeBase(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "employeeBase{name='" + name + "', empId=" + empId + "}";
    }

    @Override
    public int compareTo(employeeBase other) {
        return Integer.compare(this.empId, other.empId);
    }
}
