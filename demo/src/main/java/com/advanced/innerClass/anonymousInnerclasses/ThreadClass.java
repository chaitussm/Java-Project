package com.advanced.innerClass.anonymousInnerclasses;

public class ThreadClass extends Thread{

    public static void main(String[] args)
    {
        ThreadClass ms = new ThreadClass()
        {
            public void run()
            {
                for(int i = 0; i<=10; i++)
                {
                    System.out.println("Child Thread: " + i);
                }
            }
        };

        ms.run();
    }
    
}
