package com.objectoriented.Blocks.staticBlock;

public class InheritanceWithStaticBlock extends executionFlowInSB {

    static void methodB(){
        System.out.println("Static block in InheritanceWithStaticBlock class.");
    }

    

    public static void main(String[] args) {
        System.out.println("Main method in InheritanceWithStaticBlock class.");
            methodB();
            methodA();
    }
    
}
