package com.bt_akademi.team1.solid.dip;

import java.util.ArrayList;
import java.util.List;

// DIP'e uygun
public class Bildirim
{
    private List<Gonderebilir> mesajlar;

    public Bildirim()
    {
        mesajlar = new ArrayList<>();
    }
}
