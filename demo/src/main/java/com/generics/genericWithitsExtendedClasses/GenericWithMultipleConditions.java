package com.generics.genericWithitsExtendedClasses;

public class genericWithMultipleConditions<T extends Number & Comparable<T>> {
    private T value;

    public genericWithMultipleConditions(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isPositive() {
        return value.doubleValue() > 0;
    }

    public boolean isNegative() {
        return value.doubleValue() < 0;
    }

    public boolean isZero() {
        return value.doubleValue() == 0;
    }

    public int compareTo(T other) {
        return value.compareTo(other);
    }

    @Override
    public String toString() {
        return "genericWithMultipleConditions{" +
                "value=" + value +
                '}';
    }

    public void showValueClasses() {
        System.out.println("Class of value: " + value.getClass().getName());
        System.out.println("Superclass of value: " + value.getClass().getSuperclass().getName());
        System.out.println("Interfaces of value: ");
        for (Class<?> iface : value.getClass().getInterfaces()) {
            System.out.println("  " + iface.getName());
        }
    }

    public static void main(String[] args) {
        genericWithMultipleConditions<Integer> example = new genericWithMultipleConditions<>(5);
        System.out.println("Value: " + example.getValue());
        System.out.println("Is Positive: " + example.isPositive());
        System.out.println("Is Negative: " + example.isNegative());
        System.out.println("Is Zero: " + example.isZero());
        System.out.println("Compare to 3: " + example.compareTo(3));
        example.showValueClasses();
    }
}