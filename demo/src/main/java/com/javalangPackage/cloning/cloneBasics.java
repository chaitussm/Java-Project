package com.javalangPackage.cloning;

public class cloneBasics implements Cloneable{

    /*
     *
     * The process of creating exactly duplicate object is called cloning.
     * The main agenda of cloning is to maintain backup copy and to preserve state of an object
     * We can perform cloning by using clone() of java.lang.Object class 
     * protected native Object clone() throws CloneNotSupportedException
     * Cloneable interface present in java.lang package and it doesnt contains any methods 
     * If you are trying to perform cloning on non-cloneable objects then we will get run-time exception saying 
     * CloneNotSupportedException
     */
    
   String name = "Shiva";
   int id = 1;

   public static void main(String[] args) throws CloneNotSupportedException
   {
       cloneBasics b = new cloneBasics();

       cloneBasics b1 = (cloneBasics) b.clone();

       b1.name = "Parvathi";
       b1.id = 2;

       System.out.println(b.name + "---" + b.id);

       System.out.println(b1.name + "----" + b1.id);
   }


}
