package com.mkk.ugd.oracle.mkk.musteri_yonetim.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@SequenceGenerator(name = "CALISANLAR_SEQUENCE", sequenceName = "CALISANLAR_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "CALISANLAR")
@Entity
public class Calisan
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CALISANLAR_SEQUENCE")
    @Id
    @Column(name = "CALISAN_ID")
    private int calisanID;

    private String isim;

    private String soyisim;

    private double maas;

    @Temporal(TemporalType.DATE)
    @Column(name = "ISE_GIRIS_TARIHI")
    private Date iseGirisTarihi;

    public Calisan(String isim, String soyisim, double maas)
    {
        this.isim = isim;
        this.soyisim = soyisim;
        this.maas = maas;
        this.iseGirisTarihi = new Date();
    }

    public Calisan() {}

    public int getCalisanID() {
        return calisanID;
    }

    public void setCalisanID(int calisanID) {
        this.calisanID = calisanID;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public Date getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(Date iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "calisanID=" + calisanID +
                ", isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", maas=" + maas +
                ", iseGirisTarihi=" + iseGirisTarihi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calisan calisan = (Calisan) o;
        return calisanID == calisan.calisanID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(calisanID);
    }
}
