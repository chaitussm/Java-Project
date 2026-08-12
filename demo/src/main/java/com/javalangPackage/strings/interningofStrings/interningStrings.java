package com.javalangPackage.strings.interningofStrings;

public class interningStrings {

    /*
     * exampleOne explanation 
     * We can use intern() to get corresponding SCP object reference by using heap object reference
     * or 
     * By using heap object reference if we want to ghet corresponding SCP object reference then we should go for intern() method
     */

    public static void exampleOne()
    {
        String s1 = new String("durga");

        String s2 = s1.intern();// by doing this s2 will be pointing to s1's SCP object 

        System.out.println("Example One : " + (s1==s2));

        String s3 = "durga"; // already s1 and s2 are pointing to same SCP object s3 also pointing ot the same

        System.out.println("Example One :" + (s2 ==s3));
    }
   
    
    /*
     * exampelTwo() explanation 
     * If the corresponding SCP Object is not available then intern() method itself will create the corresponding SCP Object 
     * 
     * 
     */

    public static void exampelTwo()
    {
        String t1 = new String("durga");

        String t2 = t1.concat("software");/* In this code "software" is constant it will created in SCP 
        concatnation is taken place at runtime so the s2 = "durgasoftware" will be created in heap area*/

        String t3 = t2.intern(); /* as we dont have the s2 = "durgasoftware" in SCP  intern() will 
        create "durgasoftware" in SCP area and s3 will pointing to this object*/

        System.out.println("ExampleTwo :" + (t2==t3));

        String t4 = "durgasoftware"; // already we have s3 pointing to the "durgasoftware" object s4 also pointing to the same 

        System.out.println("ExampleTwo :" + (t3==t4));


    }
    public static void main(String[] args)
    {
        exampleOne();
        exampelTwo();

    }

    /*
     * String Constant Pool requirement 
     * In our program if a String Object is repeatedly required then it is not recommended to create 
     * separate Object for every requirement because it creates performance and memory problems 
     * instead of creating a separate Object for every requirement we have to create only one Object and we can reuse the same 
     * Object for every requirement so that performance and mermorty utilization will be improved 
     * this thing is possible because of SCP , hence the main advantages of SCP are memory utilization and performance will be improved  
     * But the main problem with SCP is , as several references pointing to the same Object, by using one reference if we are trying to 
     * change the content then remaining references will be effected to overcome this problem SUN people implemented Strings Objects as 
     * Immutable i.e once we create String Object we can't perform any changes in the existing Object if we are trying to perform any changes 
     * with those changes a new Object will be created. Hence for the SCP is the onyl reason for the immutability of the String Objects 
     * 
     * String Buffer 
     * But in StringBuffer there is no concept like SCP , hence for every requirement a separate Object will be created
     * By using one reference if we trying to change the content then there is no effect on remaining references 
     * Hence immutability concept is not required for the StringBuffer 
     * 
     */
}
