package proje4;

import java.util.Random;

public class Proje4 {

    public static void main(String[] args) {
        for (int i=0;i<20;i++)
        {
            Random rng=new Random();
            System.out.println(rng.nextInt(2)); //rng.nextInt() icine tanimlanilan deger hangi sayilarin olacagini gosterir
                                                       //Ornegin 1 koyarsak sadece 0, 2 koyarsak 0 ve 1 i alacaktir.
        }
    }
}
