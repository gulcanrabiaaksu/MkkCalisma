package com.migros.ucg.abstract_classes.matters;

import com.migros.ucg.abstract_classes.utility.MaddeTur;

public class Kure extends AbstractMadde
{
    private double yaricap;

    public Kure(MaddeTur maddeTur, double yaricap)
    {
        super(maddeTur);
        this.yaricap = yaricap;
    }

    @Override
    public double hacimHesapla()
    {
        return 4 * Math.PI * Math.pow(yaricap, 3) / 3;
    }

    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }

    @Override
    public String toString() {
        return "Kure{" +
                "yaricap=" + yaricap +
                "} " + super.toString();
    }
}
