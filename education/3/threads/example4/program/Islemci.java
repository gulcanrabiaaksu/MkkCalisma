package com.migros.ucg.threads.example4.program;

public class Islemci extends Thread
{
    /*
        Multithreading tüm sistemlerde çalışmasını garanti ettik.
        ("caching thread" durumuna engel olundu.)
     */
    private volatile boolean flag = true;

    @Override
    public void run()
    {
        while (flag)
        {
            System.out.println("flag: " + flag);
        }
    }

    public void kapat()
    {
        flag = false;
    }
}
