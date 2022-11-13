package com.mkk.ugd.threads.example7.program;


import com.mkk.ugd.utility.Timer;

/*
 *  synchronized ekleyince, calisma suresi artıyor.
 *  
 *  sayiListesi1 ve sayiListesi2 birbirinden ayri ortak veriler old icin
 *  birine erisildiginde digerine erisimin kisitlanmasi gerekmez.
 *  
 *  
 *  Bu problemin cozumu icin, multiple synchronized lock bloklari kullanildi
 *  Yani 2 ayri lock (lock1 ve lock2)
 *  Eger tek lock kullanirsak(or: lock1), ilk durumla ayni sonucu elde ederiz;
 *  yani artar.
 */
public class Run2 
{

	public static void main(String[] args) 
	{
		ProcessorWithExternalLock processor1 = new ProcessorWithExternalLock();

		Timer.start();
		processor1.calistir();
		Timer.stop();
		
		System.out.println("Gecen sure: " + Timer.getElapsedMilliseconds() + " milisaniyedir.");
	}

}
