package com.javalangPackage.strings.stringConstuctors;

public class customizedImmutabilityMethod {

    private int i;

    public customizedImmutabilityMethod(int i) {
        this.i = i;
    }

    public customizedImmutabilityMethod modify(int i) {
        if (this.i == i) {
            return this;
        } else {
            return new customizedImmutabilityMethod(i);
        }
    }

    public static void main(String[] args) {
        customizedImmutabilityMethod obj1 = new customizedImmutabilityMethod(10);
        customizedImmutabilityMethod obj2 = obj1.modify(100);
        customizedImmutabilityMethod obj3 = obj1.modify(10);

        System.out.println("obj1: " + obj1);
        System.out.println("obj2: " + obj2);
        System.out.println("obj3: " + obj3);

        System.out.println("obj1 == obj2: " + (obj1 == obj2));
        System.out.println("obj1 == obj3: " + (obj1 == obj3));

        System.out.println("obj1 hashcode: " + obj1.hashCode());
        System.out.println("obj2 hashcode: " + obj2.hashCode());
        System.out.println("obj3 hashcode: " + obj3.hashCode());

    }
    
}
