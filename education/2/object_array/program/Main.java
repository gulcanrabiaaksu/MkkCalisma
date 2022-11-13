package com.mkk.ugd.object_array.program;

public class Main
{
    public static void main(String[] args)
    {

        Sinif sinif1 = new Sinif("Cumhuriyet Lisesi", "10-B", 4);

        System.out.println(sinif1);

        Ogrenci ogrenci1 = new Ogrenci(55581, "Mahmut", "Kaya");
        sinif1.ogrenciEkle(ogrenci1);

        Ogrenci ogrenci2 = new Ogrenci(55583, "Mine", "Çalışkan");
        sinif1.ogrenciEkle(ogrenci2);

        sinif1.ogrenciEkle(new Ogrenci(55582, "Ayşe", "Doğru") );

        Ogrenci ogrenci4 = new Ogrenci(55587);
        sinif1.ogrenciEkle(ogrenci4);

        Ogrenci ogrenci5 = new Ogrenci(55585, "Fehmi", "Bilir");
        sinif1.ogrenciEkle(ogrenci5);

        System.out.println(sinif1);
    }
}
