package com.collection.set.comparatorConcepts.employeeObjects;

public class EmployeeBaseComparator implements java.util.Comparator<Object>{



    String name;
    int empId;

    public EmployeeBaseComparator(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "EmployeeBaseComparator{name='" + name + "', empId=" + empId + "}";
    }
 
    @Override
    public int compare(Object o1, Object o2) {
        
        EmployeeBaseComparator e1 = (EmployeeBaseComparator) o1;
        EmployeeBaseComparator e2 = (EmployeeBaseComparator) o2;

        String name1 = e1.name;
        String name2 = e2.name;

        // Example comparison logic based on empId
        return name1.compareTo(name2);
    }
    
}
