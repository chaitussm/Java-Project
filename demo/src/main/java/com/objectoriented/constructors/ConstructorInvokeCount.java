package com.objectoriented.constructors;

class ConstructorInvokeCount{
    
    //Other than initializaton use intance block to check count of constructor invoke 
    static int count = 0;
    
    {
       count++;
    }
    
    ConstructorInvokeCount()
    {
        
    }
    
    ConstructorInvokeCount(int i)
    {
    }
    
    ConstructorInvokeCount(String a) 
    {
    }
    
    public static void main(String[] args) {
        
        ConstructorInvokeCount obj = new ConstructorInvokeCount();
        ConstructorInvokeCount obj1 = new ConstructorInvokeCount(10);
        ConstructorInvokeCount obj2 = new ConstructorInvokeCount("Rama");
        System.out.println("Number of time constructor is invoked : " + count);

    }
    
}