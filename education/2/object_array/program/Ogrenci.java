package com.mkk.ugd.object_array.program;

import java.util.Objects;

public class Ogrenci
{
    private static final String VARSAYILAN_STR = "bilinmiyor";
    private static final int OGRENCI_ID_HANE = 5;
    private static int VARSAYILAN_ID = 10000;
    
    private int ogrenciID;
    String ad;
    String soyad;

    public Ogrenci(int ogrenciID, String ad, String soyad)
    {
        this.ogrenciID = ogrenciID;
        this.ad = ad;
        this.soyad = soyad;
    }

    public Ogrenci(String ad, String soyad)
    {
        this(VARSAYILAN_ID++, ad, soyad);
    }

    public Ogrenci(int ogrenciID) 
    {
        this(ogrenciID, VARSAYILAN_STR, VARSAYILAN_STR);
    }

    public Ogrenci()
    {
        this(VARSAYILAN_ID++, VARSAYILAN_STR, VARSAYILAN_STR);
    }

    public int getOgrenciID() {
        return ogrenciID;
    }

    public void setOgrenciID(int ogrenciID)
    {
        if(ogrenciID < 0)
        {
            System.out.println("UYARI: Öğrenci ID negatif olamaz.");
            if(this.ogrenciID == 0)
            {
                this.ogrenciID = VARSAYILAN_ID++;
            }

        }

        else
        {
            if(String.valueOf(ogrenciID).length() != OGRENCI_ID_HANE)
            {
                System.out.println("UYARI: Öğrenci ID " + OGRENCI_ID_HANE + " haneli olmalıdır.");
                if(this.ogrenciID == 0)
                {
                    this.ogrenciID = VARSAYILAN_ID++;
                }
            }
            else
            {
                this.ogrenciID = ogrenciID;
            }
        }
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "ogrenciID=" + ogrenciID +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ogrenci ogrenci = (Ogrenci) o;
        return ogrenciID == ogrenci.ogrenciID;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(ogrenciID);
    }
}
