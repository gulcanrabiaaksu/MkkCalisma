package com.migros.ucg.abstract_classes.program;

import com.migros.ucg.abstract_classes.matters.Kup;
import com.migros.ucg.abstract_classes.matters.Kure;
import com.migros.ucg.abstract_classes.utility.MaddeTur;
import com.migros.ucg.abstract_classes.utility.MaddeUtil;

public class Main
{
    public static void main(String[] args)
    {
        // kenar uzunluğu 2 cm olan altın bir küpün kütlesi
        Kup kup1 = new Kup(MaddeTur.ALTIN, 2);

        // yarıçapı 0.8 cm olan demir bir kürenin kütlesi
        Kure kure1 = new Kure(MaddeTur.DEMIR, 0.8);

        MaddeUtil.kutleBilgisiGoster(kup1);

        MaddeUtil.kutleBilgisiGoster(kure1);
    }
}
