package com.mkk.ugd.packaging.example2.program;

// 2-1-2
public class Main
{
    public static void main(String[] args)
    {
        com.mkk.ugd.packaging.example2.program.Ogrenci ogrenci1 = new Ogrenci();
        ogrenci1.neredesin();

        com.mkk.ugd.packaging.example1.program.Ogrenci ogrenci2;
        ogrenci2 = new com.mkk.ugd.packaging.example1.program.Ogrenci();
        ogrenci2.neredesin();

        Ogrenci ogrenci3;
        ogrenci3 = new Ogrenci();
        ogrenci3.neredesin();
    }
}
