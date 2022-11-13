package com.mkk.ugd.string_usage.program;


import com.mkk.ugd.string_usage.StringUtil;
import com.mkk.ugd.utility.Timer;

// https://www.javatpoint.com/difference-between-stringbuffer-and-stringbuilder
// https://www.geeksforgeeks.org/create-immutable-class-java
public class Run 
{
	private static final int ITERASYON_SAYISI = 5000000;
	
	public static void main(String[] args) 
	{
		String isim1 = "Mahmut";
		isim1 = isim1 + " Bilen"; // Yeni String nesnesi uretilir.
		
		isim1.concat("abcd");
		
		System.out.println(isim1); // Degismez.
		
		System.out.println( isim1.concat("abcd") ); // Yeni String nesnesi uretilir.

		StringBuilder stringBuilder1 = new StringBuilder();
		
		stringBuilder1.append("isim:Mahmut");
		stringBuilder1.append("maas:7000");
		stringBuilder1.append("adres:Ankara-Mamak");

		
		// metotlar syncronized oldugu icin, Thread islemlerine uygun
		StringBuffer stringBuffer1 = new StringBuffer();
		stringBuffer1.append("isim:Mahmut");
		stringBuffer1.append("maas:7000");
		stringBuffer1.append("adres:Ankara-Mamak");




		Timer.start();
		StringUtil.stringBuilderTestEt(ITERASYON_SAYISI);
		Timer.stop();
		
		System.out.println("stringBuilder " + ITERASYON_SAYISI + " iterayon icin gecen sure: " 
		+ Timer.getElapsedMilliseconds());


		Timer.start();
		StringUtil.stringBufferTestEt(ITERASYON_SAYISI);
		Timer.stop();
		
		System.out.println("\n\nstringBuffer " + ITERASYON_SAYISI + " iterayon icin gecen sure: " 
		+ Timer.getElapsedMilliseconds());

// Tehlikelidir.		
//		Zamanlayici.start();
//		Util.stringConcatTest(iterasyonSayisi);
//		Zamanlayici.stop();
//		
//		System.out.println("\n\nstringConcat " + iterasyonSayisi + " iterayon icin gecen sure: " 
//		+ Zamanlayici.getElapsedMilliseconds());
	}

}
