package com.fundamentals.Interface;

public class BankExample implements Bank {
    @Override
    public void deposit() {
        System.out.println("Deposit method implemented in BankExample.");
    }

    @Override
    public void reporate() {
        System.out.println("Reporate method implemented in BankExample.");
    }

    public static void main(String[] args) {
        BankExample bank = new BankExample();
        bank.deposit();
        bank.reporate();
        System.out.println("Rate of Interest: " + Bank.roi);
    }
}
