package com.mkk.ugd.oracle.mkk.musteri_yonetim.entity;

import com.mkk.ugd.utility.Util;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "MUSTERILER")
public class Musteri
{
    @Id
    @Column(nullable = false)
    public String TCKN;

    @Column
    private String isim;

    @Column
    private String soyisim;

    @Temporal(TemporalType.DATE)
    @Column(name = "ODEME_TARIHI")
    private Date odemeTarihi;

    @Column(name = "ODEME_MIKTARI")
    private double odemeMiktari;

    public Musteri(String TCKN, String isim, String soyisim, Date odemeTarihi, double odemeMiktari)
    {
        this.TCKN = TCKN;
        this.isim = isim;
        this.soyisim = soyisim;
        this.odemeTarihi = odemeTarihi;
        this.odemeMiktari = odemeMiktari;
    }

    public Musteri() {
        // TODO Auto-generated constructor stub
    }

    public String getTCKN() {
        return TCKN;
    }

    public void setTCKN(String TCKN)
    {
        if(!Util.isValidTCKN(TCKN))
        {
            Util.showWarningMessage("TCKN not valid.");
        }
        else
        {
            this.TCKN = TCKN;
        }
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

    public Date getOdemeTarihi() {
        return odemeTarihi;
    }

    public void setOdemeTarihi(Date odemeTarihi) {
        this.odemeTarihi = odemeTarihi;
    }

    public double getOdemeMiktari() {
        return odemeMiktari;
    }

    public void setOdemeMiktari(double odemeMiktari) {
        this.odemeMiktari = odemeMiktari;
    }

    @Override
    public String toString() {
        return "Musteri [isim=" + isim + ", soyisim=" + soyisim + ", odemeTarihi=" + odemeTarihi + ", odemeMiktari="
                + odemeMiktari + ", TCKN=" + TCKN + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musteri musteri = (Musteri) o;
        return Objects.equals(TCKN, musteri.TCKN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TCKN);
    }
}
