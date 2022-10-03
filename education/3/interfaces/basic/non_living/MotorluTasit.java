package com.migros.ucg.interfaces.basic.non_living;

/*
    MotorluTasit has a Motor.
    MotorluTasit Motor'a sahiptir.

    parça olmadan bütün var olamıyorsa (anlamını kaybediyorsa) -> zorunlu parça-bütün ilişkisi -> composition
    parça olmadan bütün var olabiliyorsa -> zorunsuz parça-bütün ilişkisi -> aggregation
 */
public class MotorluTasit // bütün
{
    private String marka;
    private Integer yil;
    private Motor motor; // parça

    public MotorluTasit(String marka, Integer yil, Motor motor) {
        this.marka = marka;
        this.yil = yil;
        this.motor = motor;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Integer getYil() {
        return yil;
    }

    public void setYil(Integer yil) {
        this.yil = yil;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "{" +
                "marka='" + marka + '\'' +
                ", yil=" + yil +
                ", motor=" + motor +
                '}';
    }
}
