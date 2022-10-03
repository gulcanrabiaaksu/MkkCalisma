package com.migros.ucg.abstract_classes.utility;

/**
 *  Madde cesit ve buna karsilik gelen yogunluk bilgilerini
 *  cekmek uzere tanimlanan enum
 */
public enum MaddeTur
{
    DEMIR(7.874),
    ALTIN(19.3),
    BAKIR(8.96),
    GUMUS(10.49);

    private double yogunluk;

    MaddeTur(double yogunluk) {
        this.yogunluk = yogunluk;
    }

    public double getYogunluk() {
        return yogunluk;
    }
}
