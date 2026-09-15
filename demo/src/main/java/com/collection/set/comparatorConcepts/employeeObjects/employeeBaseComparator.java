package com.collection.set.comparatorConcepts.employeeObjects;

public class employeeBaseComparator implements java.util.Comparator<Object>{



    String name;
    int empId;

    public employeeBaseComparator(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "employeeBaseComparator{name='" + name + "', empId=" + empId + "}";
    }
 
    @Override
    public int compare(Object o1, Object o2) {
        
        employeeBaseComparator e1 = (employeeBaseComparator) o1;
        employeeBaseComparator e2 = (employeeBaseComparator) o2;

        String name1 = e1.name;
        String name2 = e2.name;

        // Example comparison logic based on empId
        return name1.compareTo(name2);
    }
    
}
