package com.javalangPackage.strings.stringConstuctors;

public class finalVsImmutability {

    public static void finalDefinition()
    {
        //final applicable for variable, immutability applicable for object
        final StringBuilder sb = new StringBuilder("Shiva");
        sb.append("Parvathi");
        System.out.println("StringBuilder object after modification: " + sb);
        //In the above example we are able to change the content of the stringBuilder because string
    }

    public static void immutabilityDefinition()
    {
        String s = new String("Shiva");
        System.out.println("hashcode before modification: " + s.hashCode());
        s.concat("Parvathi");
        System.out.println("String object after modification: " + s);
        System.out.println("hashcode after modification: " + s.hashCode());

        //In the above example we are not able to change the content of the string because string is immutable, hence a new object will be created in the memory and the reference variable s will point to that new object
    }


    public static void main(String[] args) {

        finalDefinition();
        immutabilityDefinition();

    }
    
}
