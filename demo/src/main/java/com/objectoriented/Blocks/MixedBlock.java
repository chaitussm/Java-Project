package com.objectoriented.Blocks;

class MixedBlock {
    
    static
    {
        System.out.println("First static Block :");
    }
    
    {
        System.out.println("Instance block One");
    }
    
    MixedBlock()
    {
        System.out.println("Hello this is Constructor");
    }
    
    public static void main(String[] args) {
        
        MixedBlock mb = new MixedBlock();
        System.out.println("Main Method area");
        MixedBlock mb1 = new MixedBlock();

    }
    
    static 
    {
        System.out.println("Second static Block :");
    }
    
    {
        System.out.println("Instance block Two");
    }
}
