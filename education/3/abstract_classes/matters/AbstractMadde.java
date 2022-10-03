package com.migros.ucg.abstract_classes.matters;

import com.migros.ucg.abstract_classes.utility.MaddeTur;

public abstract class AbstractMadde
{
    private MaddeTur maddeTur;
    private double yogunluk;

    public AbstractMadde(MaddeTur maddeTur)
    {
        this.maddeTur = maddeTur;
        this.yogunluk = maddeTur.getYogunluk();
    }

    public abstract double hacimHesapla();

    public double kutleHesapla()
    {
        return yogunluk * hacimHesapla();
    }

    public double getYogunluk() {
        return yogunluk;
    }

    public void setYogunluk(double yogunluk) {
        this.yogunluk = yogunluk;
    }

    public MaddeTur getMaddeTur() {
        return maddeTur;
    }

    @Override
    public String toString() {
        return "AbstractMadde{" +
                "yogunluk=" + yogunluk +
                '}';
    }

}
