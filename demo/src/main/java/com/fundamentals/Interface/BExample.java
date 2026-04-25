package com.fundamentals.Interface;

public class BExample implements B {
    @Override
    public void methodA() {
        System.out.println("B interface methodA implemented in BExample.");
    }

    public static void main(String[] args) {
        BExample b = new BExample();
        b.methodA();
    }
}
