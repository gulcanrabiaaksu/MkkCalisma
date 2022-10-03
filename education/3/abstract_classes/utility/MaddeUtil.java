 package com.migros.ucg.abstract_classes.utility;

import com.migros.ucg.abstract_classes.matters.AbstractMadde;
import com.migros.ucg.abstract_classes.matters.Kup;
import com.migros.ucg.abstract_classes.matters.Kure;
import com.migros.ucg.utility.Util;

public final class MaddeUtil
{
    private MaddeUtil() {}

    public static void kutleBilgisiGoster(AbstractMadde madde)
    {
        String formatliKutle = String.format("%.2f", madde.kutleHesapla());
        String maddeTur = madde.getMaddeTur().toString(); // yoğunluk ile ilgili
        String maddeSekil = madde.getClass().getSimpleName(); // maddenin lekli ile ilgili (küre, küp vb.)

        // madde'nin bağlandığı nesne bir Kup nesnesi ise
        if(madde instanceof Kup)
        {
            Util.showInfoMessage("Kenar uzunluğu " + ((Kup) madde).getKenar() + " cm olan "
                    + maddeTur + " " + maddeSekil + " kütlesi: " + formatliKutle + " gr'dır.");
        }
        else if(madde instanceof Kure)
        {
            Util.showInfoMessage("Yarıçapı " + ((Kure) madde).getYaricap() + " cm olan "
                    + maddeTur + " " + maddeSekil + " kütlesi: " + formatliKutle + " gr'dır.");
        }
    }
}
