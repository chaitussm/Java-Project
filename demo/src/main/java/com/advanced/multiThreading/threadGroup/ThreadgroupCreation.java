package com.advanced.multiThreading.threadGroup;

public class threadgroupCreation {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("MyThreadGroup");
        ThreadGroup subGroup = new ThreadGroup(group, "MySubThreadGroup");
        System.out.println("Thread Group Name: " + group.getName());
        System.out.println("Sub Thread Group Name: " + subGroup.getName());
        System.out.println("Parent of Sub Thread Group: " + subGroup.getParent().getName());
        System.out.println("Parent for the group: " + group.getParent().getName());
        System.out.println("Parent for the main thread group: " + Thread.currentThread().getThreadGroup().getParent().getName());
     }
    
}
