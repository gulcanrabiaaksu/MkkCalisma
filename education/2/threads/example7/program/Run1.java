package com.mkk.ugd.threads.example7.program;

import com.mkk.ugd.utility.Timer;

public class Run1
{

	public static void main(String[] args) 
	{
		ProcessorWithInnerLock processor1 = new ProcessorWithInnerLock();
		
		Timer.start();
		processor1.calistir();
		Timer.stop();
		
		System.out.println("Gecen sure: " + Timer.getElapsedMilliseconds() + " milisaniyedir.");
	}

}
