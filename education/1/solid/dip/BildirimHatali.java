package com.bt_akademi.team1.solid.dip;

/*
    Üst sınıf (bütün)
    alt sınıflara (parçalara) bağımlı olmamalıdır.

    Bağımlılığı tersine çevirmemiz gerekmektedir.
    DIP (dependency inversion principle)
 */
public class BildirimHatali
{
    private WhatsAppMesaj whatsAppMesaj;
    private FacebookMesaj facebookMesaj;
    private SMS sms;

    public BildirimHatali()
    {
        whatsAppMesaj = new WhatsAppMesaj();
        facebookMesaj = new FacebookMesaj();
        sms = new SMS();
    }

    public void gonder()
    {
        whatsAppMesaj.gonder();
        facebookMesaj.gonder();
        sms.gonder();
    }
}
