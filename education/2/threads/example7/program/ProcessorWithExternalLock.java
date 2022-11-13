package com.mkk.ugd.threads.example7.program;

import java.util.ArrayList;
import java.util.List;

public class ProcessorWithExternalLock 
{
	private static final int LIMIT = 50;
	
	List<Integer> sayiListesi1 = new ArrayList<Integer>();
	List<Integer> sayiListesi2 = new ArrayList<Integer>();
	
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	void calistir()
	{
		Thread thread1 = new Thread(new Runnable() 
		{
			
			@Override
			public void run() 
			{
				listeleriDoldur();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() 
		{
			
			@Override
			public void run() 
			{
				listeleriDoldur();
			}
		});
		
		thread1.start();
		thread2.start();
		
		try
		{
			thread1.join();
			thread2.join();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		
		System.out.println(sayiListesi1);
		System.out.println(sayiListesi2);
	}


	void listeleriDoldur() 
	{
		for (int i = 0; i < LIMIT; i++) 
		{
			sayiListesi1ElemanEkle();
			sayiListesi2ElemanEkle();
		}
	}


	private void sayiListesi1ElemanEkle() 
	{
		synchronized (lock1) 
		{
			try
			{
				Thread.sleep(5);
			}
			catch (InterruptedException e) 
			{
				System.out.println("Hata mesaji: " + e.getMessage());
			}
			
			sayiListesi1.add( (int)(Math.random()*10) + 1 );
		}
		
	}
	
	private void sayiListesi2ElemanEkle() 
	{
		synchronized (lock2) 
		{
			try
			{
				Thread.sleep(5);
			}
			catch (InterruptedException e) 
			{
				System.out.println("Hata mesaji: " + e.getMessage());
			}
			
			sayiListesi2.add( (int)(Math.random()*10) + 1 );
		}
	}

}
