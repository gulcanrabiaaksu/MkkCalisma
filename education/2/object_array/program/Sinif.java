package com.mkk.ugd.object_array.program;

import java.util.Arrays;

public class Sinif
{
    private int indis=0;

    String okulAd;
    String sube;
    Ogrenci[] ogrenciler;


    public Sinif(String okulAd, String sube, int sinifMevcudu)
    {
        this.okulAd = okulAd;
        this.sube = sube;
        ogrenciler = new Ogrenci[sinifMevcudu];
    }

    public void ogrenciEkle(Ogrenci ogrenci)
    {
        if(indis >= ogrenciler.length)
        {
            System.out.println("UYARI: Sınıf dolu.");
            return;
        }

        ogrenciler[indis] = ogrenci;
        indis++;
    }

    @Override
    public String toString() {
        return "Sinif{" +
                "okulAd='" + okulAd + '\'' +
                "\n, sube='" + sube + '\'' +
                "\n, ogrenciler=" + Arrays.toString(ogrenciler) +
                '}';
    }

}
