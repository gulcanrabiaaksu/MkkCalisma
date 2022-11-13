package com.mkk.ugd.oracle.mkk.musteri_yonetim.program;

import com.mkk.ugd.oracle.mkk.musteri_yonetim.dal.CalisanDAL;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.dal.MusteriDAL;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.entity.Calisan;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.entity.Musteri;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.utility.HibernateUtil;
import com.mkk.ugd.utility.Util;

import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        CalisanDAL calisanDAL1 = new CalisanDAL();

        calisanDAL1.ekle(new Calisan("Ali", "Bulut", 18450));

        // calisanDAL1.sil(4);

        MusteriDAL musteriDAL1 = new MusteriDAL();
        musteriDAL1.ekle(new Musteri("98149332526", "Halis", "Bilir", new Date(), 4250));
        musteriDAL1.ekle(new Musteri("57440376882", "Mine", "Çalışkan", new Date(), 3900));
        musteriDAL1.ekle(new Musteri("23154665192", "Ferit", "Uçmak", new Date(), 1550));

        Util.showList( calisanDAL1.tumVarlilariCek() );

        Util.showList( musteriDAL1.tumVarlilariCek() );

        HibernateUtil.closeSessionFactory();
    }
}

