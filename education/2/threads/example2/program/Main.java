package com.mkk.ugd.threads.example2.program;

public class Main
{
    public static void main(String[] args)
    {
        Islemci islemci = new Islemci();

        Thread thread1 = new Thread(islemci);
        Thread thread2 = new Thread(islemci);

        thread1.start();
        thread2.start();
    }
}
