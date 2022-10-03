package com.migros.ucg.interfaces.basic.non_living;

import com.migros.ucg.interfaces.basic.utility.Ucabilir;

public abstract class AbstractHavaMotorluTasiti extends MotorluTasit implements Ucabilir
{
    private int ucmaAparatiAdet;

    public AbstractHavaMotorluTasiti(String marka, Integer yil, Motor motor, int ucmaAparatiAdet)
    {
        super(marka, yil, motor);
        this.ucmaAparatiAdet = ucmaAparatiAdet;
    }

    public int getUcmaAparatiAdet() {
        return ucmaAparatiAdet;
    }

    public void setUcmaAparatiAdet(int ucmaAparatiAdet) {
        this.ucmaAparatiAdet = ucmaAparatiAdet;
    }

    @Override
    public String toString() {
        return "HavaMotorluTasiti{" +
                "ucmaAparatiAdet=" + ucmaAparatiAdet +
                "} " + super.toString();
    }
}
