package com.javalangPackage.strings;

public class immutabilityMutability {

    public static void main(String[] args) {
        String s = new String("Shiva");
        System.out.println("Hashcode before modification: " + s.hashCode());
        System.out.println("Object name before modification: " + s);
        s = s + "Parvathi";
        System.out.println("Hashcode after modification: " + s.hashCode());
        System.out.println("Object name after modification: " + s);
        /*In the above example we are trying to change the content of the string but we are not able to change the content of the string
         * because string is immutable, hence a new object will be created in the memory and the reference variable s will point to that new object
         * Thats why hashcode got changed after modification because a new object is created in the memory and the reference variable s 
         * will point to that new object
         * Hence we can say that string is immutable
         */

        StringBuffer sb = new StringBuffer("Shiva");
        System.out.println("Hashcode before modification: " + sb.hashCode());
        System.out.println("Object name before modification: " + sb);
        sb.append("Parvathi");
        System.out.println("Hashcode after modification: " + sb.hashCode());
        System.out.println("Object name after modification: " + sb);
        /*In the above example we are able to change the content of the stringBuffer because stringBuffer is mutable, hence no new object will be created in the memory and the reference variable sb will point to same object
         * Hence we can say that stringBuffer is mutable
         */
    }
    
}
