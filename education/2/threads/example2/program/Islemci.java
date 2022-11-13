package com.mkk.ugd.threads.example2.program;

public class Islemci implements Runnable
{
    private static final int LIMIT = 5;

    @Override
    public void run()
    {
        for (int i = 0; i < LIMIT; i++)
        {
            System.out.println((i+1) + "³ = " + Math.pow((i+1), 3)
                    + " - thread ad: " + Thread.currentThread().getName());
        }
    }
}
