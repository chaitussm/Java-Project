package com.advanced.multiThreading;

public class OverloadingInMultithreading extends Thread {

    @Override
    public void run() {
        
        System.out.println("No-arg Method run() is called");
    }

    public void run(int x) {
        
        System.out.println("Overloaded Method run(int x) is called with value: " + x);        
    }

    public static void main(String[] args) {
        OverloadingInMultithreading thread = new OverloadingInMultithreading();
        thread.start();
        
    }
    
    /*Only no arg method is called by the start() method
     because the start() method calls the run() method internally
     we have to call the overloaded method explicitly*/

    
}
