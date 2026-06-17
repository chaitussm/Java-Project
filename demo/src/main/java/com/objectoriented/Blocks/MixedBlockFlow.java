package com.objectoriented.Blocks;

class MixedBlockFlow {
    
    private static String data(String str)
    {
        System.out.println(str);
        return str;
    }
    
    static String value = data("1");
    
    {
        value = data("2");
    }
    
    static 
    {
        value = data("3");
    }
    
    public static void main(String[] args) {
        
        Object mb = new MixedBlockFlow();
        System.out.println("Main Method area");

    }
    
}
