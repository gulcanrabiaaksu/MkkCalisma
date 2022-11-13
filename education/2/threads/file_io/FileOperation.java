package com.mkk.ugd.threads.file_io;

import com.mkk.ugd.utility.Util;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileOperation 
{
	private static final String FIRST_NAME_FILE = "first_names.txt";
	private static final String LAST_NAME_FILE = "last_names.txt";
	private static final String MIDDLE_NAME_FILE = "middle_names.txt";
	private static final int MIDDLE_NAME_WORD_LIMIT = 2;
	
	private BufferedReader bufferedReader;
	private FileInputStream fileInputStream;
	
	public FileOperation(String filePath) 
	{
		try 
		{
			fileInputStream = new FileInputStream(filePath);
			bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		} 
		catch (FileNotFoundException e) 
		{
			Util.showGeneralExceptionInfo(e);
		}
		
	}
	
	public void splitNamesAndCreateFiles()
	{
		
		
		try
		(
			BufferedWriter bufferedWriterFirstName = new BufferedWriter(new FileWriter(FIRST_NAME_FILE));
			BufferedWriter bufferedWriterLastName = new BufferedWriter(new FileWriter(LAST_NAME_FILE));	
			BufferedWriter bufferedWriterMiddleName = new BufferedWriter(new FileWriter(MIDDLE_NAME_FILE));	
		)
		{
			System.out.println(FIRST_NAME_FILE + "\n" + LAST_NAME_FILE 
					 			 + "\n" + MIDDLE_NAME_FILE + "\n"
					 			 + " files are created.");
			
			// "File pointer" dosya basina alinir.
			fileInputStream.getChannel().position(0);
			
			String line;
			int wordCount;
			String firstName;		
			String lastName;
			List<String> middleName;
			while((line = bufferedReader.readLine()) != null)
			{
				firstName = line.split(" ")[0];
				bufferedWriterFirstName.write(firstName + "\n");
				
				wordCount = line.split(" ").length;
				lastName = line.split(" ")[wordCount-1];
				bufferedWriterLastName.write(lastName + "\n");
				
				if(wordCount > MIDDLE_NAME_WORD_LIMIT)
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
	
	public void findWord(String word)
	{
		try
		{
			// "File pointer" dosya basina alinir.
			fileInputStream.getChannel().position(0);
			
			String line;
			int counter = 0;
			boolean isFound = false;
			while((line = bufferedReader.readLine()) != null)
			{
				counter++;
				if(line.contains(word))
				{
					isFound = true;
					Util.showInfoMessage("Word: " + word + " is found at " + counter + "'th line");
				}
			}
			
			if(!isFound)
			{
				Util.showInfoMessage("Word: " + word + " is not found");
			}
		}
		catch (IOException e) 
		{
			Util.showGeneralExceptionInfo(e);
		}
	}
}
