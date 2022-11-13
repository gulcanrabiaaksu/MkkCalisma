package com.mkk.ugd.file_io.example1.program;

import com.mkk.ugd.utility.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Run 
{

	public static final String okunacakDosya = "employees.txt";
	public static final String yazilacakDosya = "employeesCopy.txt";
	
	public static void main(String[] args) 
	{
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		
		try
		{
			fileInputStream = new FileInputStream(okunacakDosya);
			Util.showInfoMessage(okunacakDosya + " dosyasi okundu.");
			
			fileOutputStream = new FileOutputStream(yazilacakDosya);
			Util.showInfoMessage(yazilacakDosya + " dosyasi olusturuldu.");
			
			byte b;
			while(  ( b = (byte)fileInputStream.read() ) != -1 )
			{
				fileOutputStream.write(b);
			}
		}
		catch (FileNotFoundException e)
		{
			Util.showWarningMessage(okunacakDosya + " dosyasi bulunamadi.");
		}
		catch (IOException e)
		{
			Util.showWarningMessage("I/O hatasi. Hata mesaji:" + e.getMessage());
		}
		finally
		{
			try
			{
				if(fileInputStream != null)	fileInputStream.close();
				if(fileOutputStream != null) fileOutputStream.close();
			}
			catch (IOException e)
			{
				Util.showWarningMessage("Dosya kapatma esnasinda bir hata meydana geldi."
						+ "\nHata mesaji:" + e.getMessage());
			}
		}
	}

}
