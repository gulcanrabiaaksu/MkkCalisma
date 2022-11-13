package com.mkk.ugd.packaging.example3.program;

import com.mkk.ugd.packaging.example1.program.Ogrenci;

// 1-3-2-1
public class Main
{
    public static void main(String[] args)
    {
        Ogrenci ogrenci1 = new Ogrenci();
        ogrenci1.neredesin();

        com.mkk.ugd.packaging.example3.program.Ogrenci ogrenci2;
        ogrenci2 = new com.mkk.ugd.packaging.example3.program.Ogrenci();
        ogrenci2.neredesin();

        com.mkk.ugd.packaging.example2.program.Ogrenci ogrenci3;
        ogrenci3 = new com.mkk.ugd.packaging.example2.program.Ogrenci();
        ogrenci3.neredesin();

        com.mkk.ugd.packaging.example1.program.Ogrenci ogrenci4 = new Ogrenci();
        ogrenci4.neredesin();
    }
}
