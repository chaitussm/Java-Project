package com.javalangPackage.strings.ImportantConcept;

final class OurOwnImmutableClass {


       private int value;

       OurOwnImmutableClass(int value)
       {
          this.value = value;
       }

       public OurOwnImmutableClass update(int inputValue)
       {
           if(this.value == inputValue)
           {
             return this;
           }

           else 
           {
             return new OurOwnImmutableClass(inputValue);
           }
       }

       public static void main(String[] args)
       {
           OurOwnImmutableClass os = new OurOwnImmutableClass(10);
           OurOwnImmutableClass os1 = os.update(100);
           OurOwnImmutableClass os2 = os.update(10);

           System.out.println(os == os1);

           System.out.println(os == os2);
       }


    
}
