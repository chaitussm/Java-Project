package com.generics.genericWithitsExtendedClasses;

public class GenericWithThreadClasses<T extends Thread> {
    private T value;

    public GenericWithThreadClasses(T value) {
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
        GenericWithThreadClasses<Thread> example = new GenericWithThreadClasses<>(new Thread());
        example.printGenericClass();
    }
}
