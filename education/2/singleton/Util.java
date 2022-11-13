package com.mkk.ugd.singleton;

public final class Util
{
    private static Util INSTANCE;

    private String ortakKisim;

    private Util(String ortakKisim)
    {
        this.ortakKisim = ortakKisim;
    }

    public static Util getINSTANCE(String ortakKisim)
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Util(ortakKisim);
        }

        return INSTANCE;
    }

    public void method1()
    {

    }

    public void method2()
    {

    }

    public void method3()
    {

    }
}
