package com.migros.ucg.abstract_classes.matters;

import com.migros.ucg.abstract_classes.utility.MaddeTur;

public class Kup extends AbstractMadde
{
    private double kenar;

    public Kup(MaddeTur maddeTur, double kenar)
    {
        super(maddeTur);
        this.kenar = kenar;
    }

    @Override
    public double hacimHesapla()
    {
        return Math.pow(kenar, 3);
    }

    public double getKenar() {
        return kenar;
    }

    public void setKenar(double kenar) {
        this.kenar = kenar;
    }

    @Override
    public String toString() {
        return "Kup{" +
                "kenar=" + kenar +
                "} " + super.toString();
    }
}
