package com.advanced.innerClass.nestedClassesAndInterfaces;

public class interfaceInsideClass {

    /*
     *
     *
     * Inside a class if we require multiple implementation of interface and all these implemantations 
     * are realted to a particular class then we can define interface inside a class
     */

    interface protein
    {
        public String type();
    }

    class wheyProtein implements protein{

        public String type()
        {
            return "whey";
        } 
    }

    class casein implements protein{

        public String type()
        {
            return "slow digestion";
        }
    }

    public static void main(String[] args)
    {
        interfaceInsideClass in = new interfaceInsideClass();
        wheyProtein wp = in.new wheyProtein();
        casein cs = in.new casein();
        System.out.println(wp.type());
        System.out.println(cs.type());
    }
    
}
