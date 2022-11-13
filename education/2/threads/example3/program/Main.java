package com.mkk.ugd.threads.example3.program;

public class Main
{
    public static void main(String[] args)
    {
        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Merhaba. ");
            }
        });
        thread1.start();

        System.out.println("Nasılsın ?");
    }
}
