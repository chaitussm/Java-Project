package com.advanced.innerClass.example2;

public class supplementClass {

    class protein
    {
        public void whey()
        {
            System.out.println("Hello I am whey");
        }

        public void casein()
        {
            System.out.println("Hello I am slow digesting protein");

            protein p = new protein();

            p.whey();
        }
    }
    
    public static void main(String[] args)
    {
        supplementClass sp = new supplementClass();

        supplementClass.protein pro = sp.new protein();

        //pro.whey();
        /*Here calling the method inside the inner class using instance block is easy when compared 
        with calling the same from the static area*/
        pro.casein();
    }
    
}
