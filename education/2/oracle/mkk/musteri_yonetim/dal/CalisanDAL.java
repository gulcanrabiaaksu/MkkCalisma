package com.mkk.ugd.oracle.mkk.musteri_yonetim.dal;

import com.mkk.ugd.oracle.mkk.musteri_yonetim.entity.Calisan;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.utility.TabloAd;

public class CalisanDAL extends VarlikDAL<Calisan, Integer>
{
    public CalisanDAL()
    {
        super(Calisan.class, TabloAd.CALISANLAR);
    }
}
