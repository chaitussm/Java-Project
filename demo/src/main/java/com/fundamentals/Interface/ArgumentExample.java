package com.fundamentals.Interface;

public class ArgumentExample implements Argument {
    @Override
    public void arg(int i) {
        System.out.println("Argument method implemented in ArgumentExample with value: " + i);
    }

    public static void main(String[] args) {
        ArgumentExample arg = new ArgumentExample();
        arg.arg(42);
    }
}
