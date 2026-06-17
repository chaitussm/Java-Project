package com.objectoriented.Blocks;

class MixedBlockOrder {
    
    private static String data(String str)
    {
        System.out.println(str);
        return str;
    }
    
    MixedBlockOrder()
    {
        value = data("3");
    }
    
    {
        value = data("1");
    }
    
    String value = data("2");
    
    public static void main(String[] args) {
        
        Object mb = new MixedBlockOrder();
        System.out.println("Main Method area");

    }
    
}
