package com.collections.set.comparatorConcepts.employeeObjects;

import java.util.TreeSet;

public class employeeDemo {

    public static void demoWithComparable()
    {
       employeeBase emp1 = new employeeBase("Rama", 101);
        employeeBase emp2 = new employeeBase("Sita", 102);
        employeeBase emp3 = new employeeBase("Lakshman", 103);
        employeeBase emp4 = new employeeBase("Bharat", 104);
        employeeBase emp5 = new employeeBase("Shatrughna", 105);
        
        // REMOVED Comparator: TreeSet now uses natural sorting (compareTo)
        TreeSet<employeeBase> employeeSet = new TreeSet<>();
        
        employeeSet.add(emp1);
        employeeSet.add(emp2);
        employeeSet.add(emp3);
        employeeSet.add(emp4);
        employeeSet.add(emp5);
        
        System.out.println(employeeSet);
    }

    public static void demoWithComparator()
    {
        employeeBaseComparator empComp1 = new employeeBaseComparator("Rama", 101);
        employeeBaseComparator empComp2 = new employeeBaseComparator("Sita", 102);
        employeeBaseComparator empComp3 = new employeeBaseComparator("Lakshman", 103);
        employeeBaseComparator empComp4 = new employeeBaseComparator("Bharat", 104);
        employeeBaseComparator empComp5 = new employeeBaseComparator("Shatrughna", 105);

        TreeSet<employeeBaseComparator> employeeSet = new TreeSet<>(new employeeBaseComparator("", 0));

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
