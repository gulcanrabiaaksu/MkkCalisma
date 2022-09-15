//Dizinin elemanlarini alinca sonsuz donguye giriyor.İlgilenilecek
package proje5;

import java.util.Random;
import java.util.Scanner;

//FİSHERYATESDZİKARMA

public class Proje5 {
    static int[] fisherYatesKaristir(int[]arr, int n){
        int[] a =new int [n];
        int[] ind =new int[n];
        for(int i=0;i<n;i++)
            ind[i]=0;
        int index;
        Random rand =new Random();
        for(int i=0;i<n;i++)
        {
            do
            {
                index= rand.nextInt();
            }
            while(ind[index] !=0);
            
            ind[index]=1;
            a[i] = arr[index];
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Dizi boyutunu giriniz: "); 
        int n =sc.nextInt();
        int []a=new int[n];
        int []res=new int[n];
        /*
        if(n==0){
            System.out.println("Yanlis dizi boyutu girdiniz. Tekrar deneyiniz. "); 
        }
        else{*/
            
        Random rng=new Random();
        
        System.out.println("Dizinin elemanlarini giriniz:");
        for(int i=0;i<n;i++)
        {
            a[i] =rng.nextInt(100);
        }
        
        res = fisherYatesKaristir(a,n);
        System.out.println("****: ");
        for(int i=0; i<n;i++)
        {
           System.out.print(res[i]+" ");
        }
        sc.close();
    }
}

