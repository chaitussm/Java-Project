package com.advanced.innerClass.anonymousInnerclasses.example1;

public class runnableInterface implements Runnable{

      @Override
    public void run() {
        
    }

    public static void main(String[] args)
    {
        runnableInterface rn = new runnableInterface()
        {
            public void run()
            {
                for(int i = 0 ; i<10; i++)
                {
                    System.out.println("Child Thread:" + i);
                }
            }

        };

        Thread t = new Thread(rn);

        t.start();

        for(int i = 0; i<10 ; i++)
        {
            System.out.println("Main Thread: " + i);
        }

    }

  
    
}
