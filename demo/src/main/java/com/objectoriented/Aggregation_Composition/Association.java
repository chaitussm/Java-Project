package com.objectoriented.Aggregation_Composition;
import java.io.*;
import java.util.*;

// Class 1
// Bank class
class Bank {
    public static void main(String[] args) {
        Bank bank = new Bank("DemoBank");
        System.out.println("Bank name: " + bank.getBankName());
    }

    // Attributes of bank
    private String bankName;
    private Set<Employee> employees;
  
    // Constructor of Bank class
    public Bank(String bankName)
    {
        this.bankName = bankName;
    }

    // Method of Bank class
    public String getBankName()
    {
        // Returning name of bank
        return this.bankName;
    }

    public void setEmployees(Set<Employee> employees)
    {
        this.employees = employees;
    }
  
    public Set<Employee> getEmployees()
    {
        return this.employees;
    }
}

// Class 2
// Employee class
class Employee {
    public static void main(String[] args) {
        Employee emp = new Employee("DemoEmployee");
        System.out.println("Employee name: " + emp.getEmployeeName());
    }
  
    // Attributes of employee
    private String name;
  
    // Constructor of Employee class
    public Employee(String name)
    {
        // this keyword refers to current instance
        this.name = name;
    }

    // Method of Employee class
    public String getEmployeeName()
    {
        // returning the name of employee
        return this.name;
    }
}

// Class 3
// Association between both the
// classes in main method
class AssociationExample {

    // Main driver method
    public static void main(String[] args)
    {
        // Creating Employee objects
        Employee emp1 = new Employee("Ridhi");
          Employee emp2 = new Employee("Vijay");
        
          // adding the employees to a set
        Set<Employee> employees = new HashSet<>();
        employees.add(emp1);
          employees.add(emp2);

          // Creating a Bank object
          Bank bank = new Bank("ICICI");
      
          // setting the employees for the Bank object
        bank.setEmployees(employees);
        
          // traversing and displaying the bank employees 
          for (Employee emp : bank.getEmployees()) {
              System.out.println(emp.getEmployeeName()
                                 + " belongs to bank "
                                 + bank.getBankName());
        }
    }
}