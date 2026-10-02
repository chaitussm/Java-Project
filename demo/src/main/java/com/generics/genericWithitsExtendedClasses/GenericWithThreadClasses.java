package com.generics.genericWithitsExtendedClasses;

public class genericWithThreadClasses<T extends Thread> {
    private T value;

    public genericWithThreadClasses(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void printGenericClass() {
        System.out.println("Generic Class is: " + value.getClass().getName());
    }

    public static void main(String[] args) {
        genericWithThreadClasses<Thread> example = new genericWithThreadClasses<>(new Thread());
        example.printGenericClass();
    }
}
