package com.collection.set.comparatorConcepts.employeeObjects;

import java.util.TreeSet;

public class EmployeeDemo {

    public static void demoWithComparable()
    {
       EmployeeBase emp1 = new EmployeeBase("Rama", 101);
        EmployeeBase emp2 = new EmployeeBase("Sita", 102);
        EmployeeBase emp3 = new EmployeeBase("Lakshman", 103);
        EmployeeBase emp4 = new EmployeeBase("Bharat", 104);
        EmployeeBase emp5 = new EmployeeBase("Shatrughna", 105);
        
        // REMOVED Comparator: TreeSet now uses natural sorting (compareTo)
        TreeSet<EmployeeBase> employeeSet = new TreeSet<>();
        
        employeeSet.add(emp1);
        employeeSet.add(emp2);
        employeeSet.add(emp3);
        employeeSet.add(emp4);
        employeeSet.add(emp5);
        
        System.out.println(employeeSet);
    }

    public static void demoWithComparator()
    {
        EmployeeBaseComparator empComp1 = new EmployeeBaseComparator("Rama", 101);
        EmployeeBaseComparator empComp2 = new EmployeeBaseComparator("Sita", 102);
        EmployeeBaseComparator empComp3 = new EmployeeBaseComparator("Lakshman", 103);
        EmployeeBaseComparator empComp4 = new EmployeeBaseComparator("Bharat", 104);
        EmployeeBaseComparator empComp5 = new EmployeeBaseComparator("Shatrughna", 105);

        TreeSet<EmployeeBaseComparator> employeeSet = new TreeSet<>(new EmployeeBaseComparator("", 0));

        employeeSet.add(empComp1);
        employeeSet.add(empComp2);
        employeeSet.add(empComp3);
        employeeSet.add(empComp4);
        employeeSet.add(empComp5);

        System.out.println(employeeSet);
    }

    public static void main(String[] args) {
        demoWithComparable();
        demoWithComparator();
    }
}
