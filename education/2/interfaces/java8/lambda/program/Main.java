package com.mkk.ugd.interfaces.java8.lambda.program;

public class Main
{
    public static void main(String[] args)
    {
        Arayabilir arayabilir1 = new Arayabilir()
        {
            @Override
            public void aramaYap(String aranacakNumara)
            {

            }
        };


        calistir(aranacakNumara ->
                {
                    if(aranacakNumara.startsWith("444"))
                    {
                        System.out.println("Aranacak numara hatalı.");
                    }
                    else
                    {
                        System.out.println("Aranacak numara: " + aranacakNumara);
                    }
                }
        ,
       "0555 444 33 22");
    }

    public static void calistir(Arayabilir arayabilir, String telNo)
    {
        arayabilir.aramaYap(telNo);
    }
}
