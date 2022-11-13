package com.mkk.ugd.threads.file_io;

import com.mkk.ugd.utility.Util;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileProcessor 
{
	private static final String FIRST_NAME_FILE = "first_names2.txt";
	private static final String LAST_NAME_FILE = "last_names2.txt";
	private static final String MIDDLE_NAME_FILE = "middle_names2.txt";
	private static final int MIDDLE_NAME_LIMIT = 2;
	private String filePath;

	public FileProcessor(String filePath)
	{
		this.filePath = filePath;
	}
	
	private void executeMiddleNameOperation()
	{
		try
		(
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			BufferedWriter bufferedWriterMiddleName = new BufferedWriter(new FileWriter(MIDDLE_NAME_FILE));	
		)
		{
			String line;
			List<String> middleName;
			int wordCount;
			while ( (line = bufferedReader.readLine()) != null ) 
			{
				wordCount = line.split(" ").length;
				if(wordCount > MIDDLE_NAME_LIMIT)
				{
					middleName = Arrays.asList(line.split(" ")).subList(1, wordCount-1);
					bufferedWriterMiddleName.write(Util.arrangeList(middleName) + "\n");
				}
			}
		}
		catch (IOException e) 
		{
			Util.showGeneralExceptionInfo(e);
		}
		
	}
	
	private void executeLastNameOperation()
	{
		try
		(
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			BufferedWriter bufferedWriterLastName = new BufferedWriter(new FileWriter(LAST_NAME_FILE));	
		)
		{
			String line;
			int wordNumber;
			while ( (line = bufferedReader.readLine()) != null ) 
			{
				wordNumber = line.split(" ").length;
				bufferedWriterLastName.write(line.split(" ")[wordNumber-1] + "\n");
			}
		}
		catch (IOException e) 
		{
			Util.showGeneralExceptionInfo(e);
		}
		
	}
	
	private void executeFirstNameOperation()
	{
		try
		(
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			BufferedWriter bufferedWriterFirstName = new BufferedWriter(new FileWriter(FIRST_NAME_FILE));	
		)
		{
			String line;
			while ( (line = bufferedReader.readLine()) != null ) 
			{
				bufferedWriterFirstName.write(line.split(" ")[0] + "\n");
			}
		}
		catch (IOException e) 
		{
			Util.showGeneralExceptionInfo(e);
		}
	}
	
	public void divideFileOperations()
	{
		Thread threadFirstName = new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				executeFirstNameOperation();
			}
			
		});
		
		Thread threadLastName = new Thread(new Runnable() 
		{
			
			@Override
			public void run() 
			{
				executeLastNameOperation();
			}
			
		});
		
		Thread threadMiddleName = new Thread(new Runnable() 
		{
			
			@Override
			public void run() 
			{
				executeMiddleNameOperation();
			}
			
		});
		
		threadFirstName.start();
		threadLastName.start();
		threadMiddleName.start();
		
		try 
		{
			threadFirstName.join();
			threadLastName.join();
			threadMiddleName.join();
		} 
		catch (InterruptedException e) 
		{
			Util.showGeneralExceptionInfo(e);
		}
	}
}
