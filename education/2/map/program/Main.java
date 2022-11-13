package com.mkk.ugd.map.program;

import com.mkk.ugd.oracle.mkk.musteri_yonetim.dal.MusteriDAL;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.entity.Musteri;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.utility.HibernateUtil;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main
{
    public static void main(String[] args)
    {
        MusteriDAL musteriDAL = new MusteriDAL();
        List<Musteri> musteriListesi1 = musteriDAL.tumVarlilariCek();

        String telNo;
        Map<String, Musteri> musteriMap1 = new HashMap<>();
        for (Musteri musteri : musteriListesi1)
        {
            telNo = JOptionPane.showInputDialog(musteri.getIsim() + " " + musteri.getSoyisim() + " için tel no giriniz:");
            musteriMap1.put(telNo, musteri);
        }

        Set<Map.Entry<String, Musteri>> entrySet1  = musteriMap1.entrySet();

        for (Map.Entry<String, Musteri> entry : entrySet1)
        {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        HibernateUtil.closeSessionFactory();
    }
}
