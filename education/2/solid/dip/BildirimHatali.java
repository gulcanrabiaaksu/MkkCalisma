package com.mkk.ugd.solid.dip;

/*
    Üst sınıf (has a relation'a sahip olan)
    alt sınıflara bağımlı olmamalıdır.

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
