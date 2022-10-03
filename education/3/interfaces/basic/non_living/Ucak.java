package com.migros.ucg.interfaces.basic.non_living;

public class Ucak extends AbstractHavaMotorluTasiti
{

    public Ucak(String marka, Integer yil, Motor motor, int ucmaAparatiAdet) {
        super(marka, yil, motor, ucmaAparatiAdet);
    }

    @Override
    public void uc() {

    }
}
