package proje3;
//DOSYALAMA ISLEMLERI

import java.io.File;
import java.io.FilterOutputStream;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Proje3 {
    public static void DosyaYaz(String veri) throws FileNotFoundException{
        File file=new File("C:\\Users\\GÜLCAN RABİA\\Desktop\\deneme1.txt");
        FileOutputStream dosya=new FileOutputStream(file);
        //FileOutputStream dosya=new FileOutputStream(file,true); //true ifadesi onceden yazilan yazilarin silinmemesini saglar.
        try{
        dosya.write(veri.getBytes());//dosyaya yazicaz byte byte okuyarak
        dosya.flush();
        dosya.close();
    }
        catch(Exception e){
        e.printStackTrace();
    }
}
    public static void DosyaOku(){
        File file=new File("C:\\Users\\GÜLCAN RABİA\\Desktop\\deneme1.txt");
        
        try{
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine()); 
            }
            sc.close();
    }catch(FileNotFoundException e){
    }
}
    public static void main(String[] args) throws FileNotFoundException {
        
        DosyaOku();
        DosyaYaz("denemedenemedenemedenemedenemedeneme");
        DosyaOku();
    }
}

