package com.mkk.ugd.threads.file_io.program;

import com.mkk.ugd.threads.file_io.FileOperation;
import com.mkk.ugd.threads.file_io.FileProcessor;
import com.mkk.ugd.utility.Timer;

public class Main
{
	private static final String FILE_NAME_READ = "employees.txt";

	public static void main(String[] args) 
	{
		FileOperation fileOperation1 = new FileOperation(FILE_NAME_READ);
		
		Timer.start();
		fileOperation1.splitNamesAndCreateFiles();
		Timer.stop();
		
		System.out.println("Dosyalari olusturmak icin gecen sure: " 
		+ Timer.getElapsedMilliseconds() + " milisaniyedir.");
		
		
		FileProcessor fileProcessor1 = new FileProcessor(FILE_NAME_READ);
		Timer.start();
		fileProcessor1.divideFileOperations();
		Timer.stop();
		
		System.out.println("\nDosyalari olusturmak icin gecen sure: " 
				+ Timer.getElapsedMilliseconds() + " milisaniyedir.");
	}
}
