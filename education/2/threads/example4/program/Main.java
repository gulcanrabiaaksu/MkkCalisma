package com.mkk.ugd.threads.example4.program;

import com.mkk.ugd.utility.Util;

public class Main
{
    private static final int SANIYE = 1000;

    public static void main(String[] args)
    {
        Islemci islemci1 = new Islemci();
        islemci1.start();

        try
        {
            Thread.sleep(2*SANIYE);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            Util.showGeneralExceptionInfo(e);
        }

        islemci1.kapat();
    }
}
