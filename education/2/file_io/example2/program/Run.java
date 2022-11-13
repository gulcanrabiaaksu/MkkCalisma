package com.mkk.ugd.file_io.example2.program;

import com.mkk.ugd.utility.Util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Run 
{

	public static final String okunacakDosya = "employees.txt";
	public static final String yazilacakDosya = "employeesCopy2.txt";
	
	public static void main(String[] args) 
	{
		
		// Bu kullanima, try with resource izin vermez.
//		FileReader fileReader = null;
//		FileWriter fileWriter = null;
		
		try
		(
			FileReader fileReader = new FileReader(okunacakDosya);
			FileWriter fileWriter = new FileWriter(yazilacakDosya);
		)
		{
			
			int ch;
			while ( ( ch = fileReader.read() ) != -1 )
			{
				fileWriter.write(ch);
			}

			Util.showInfoMessage(yazilacakDosya + " dosyasi olusturuldu.");
		}
		catch (IOException e)
		{
			Util.showWarningMessage("I/O hatasi meydana geldi. Mesaj:" + e.getMessage());
		}
	}

}
