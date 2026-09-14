package com.collections.set.comparatorConcepts.employeeObjects;

import java.lang.Comparable;


public class employeeBase implements Comparable<Object>
{

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

    // Overriding compareTo using Object parameter and casting
    @Override
    public int compareTo(Object obj) {
        int empdId1 = this.empId;
        
        // Casting Object back to employeeBase
        employeeBase emp = (employeeBase) obj; 
        int empId2 = emp.empId;

        if(empdId1 < empId2)
            return -1;
        else if(empdId1 > empId2)
            return 1;
        else
            return 0;
    }

}
