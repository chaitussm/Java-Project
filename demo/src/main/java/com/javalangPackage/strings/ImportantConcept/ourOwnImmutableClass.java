package com.javalangPackage.strings.ImportantConcept;

import java.nio.channels.UnsupportedAddressTypeException;

final class ourOwnImmutableClass {


       private int value;

       ourOwnImmutableClass(int value)
       {
          this.value = value;
       }

       public ourOwnImmutableClass update(int inputValue)
       {
           if(this.value == inputValue)
           {
             return this;
           }

           else 
           {
             return new ourOwnImmutableClass(inputValue);
           }
       }

       public static void main(String[] args)
       {
           ourOwnImmutableClass os = new ourOwnImmutableClass(10);
           ourOwnImmutableClass os1 = os.update(100);
           ourOwnImmutableClass os2 = os.update(10);

           System.out.println(os == os1);

           System.out.println(os == os2);
       }


    
}
