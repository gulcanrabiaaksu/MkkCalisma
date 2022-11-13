package com.mkk.ugd.oracle.mkk.musteri_yonetim.dal;


import com.mkk.ugd.oracle.mkk.musteri_yonetim.entity.Musteri;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.utility.TabloAd;

public class MusteriDAL extends VarlikDAL<Musteri, String>
{
    public MusteriDAL()
    {
        super(Musteri.class, TabloAd.MUSTERILER);
    }
}
