package com.mkk.ugd.file_io.example3.program;

import com.mkk.ugd.utility.Util;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Run
{

	public static final String okunacakDosya = "employees.txt";
	
	public static void main(String[] args) 
	{
		BufferedReader bufferedReader = null;
		
		try
		{
			bufferedReader = new BufferedReader(new FileReader(okunacakDosya));
			
			String arananKelime = JOptionPane.showInputDialog("Dosyada aranacak kelimeyi giriniz:");
			
			boolean kelimeBulunduMu = false;
			String line;
			int sayac = 0;
			while( ( line = bufferedReader.readLine() ) != null)
			{
				sayac++;
				if(line.contains(arananKelime))
				{
					Util.showInfoMessage("Aranan kelime " + arananKelime + " " + sayac + "'inci satirda bulunmaktadir.");
					kelimeBulunduMu = true;
				}
			}
			
			if(!kelimeBulunduMu)
			{
				Util.showInfoMessage("Aranan kelime " + arananKelime + " dosyada bulunamadi.");
			}
		}
		catch (FileNotFoundException e) 
		{
			Util.showWarningMessage(okunacakDosya + " dosyasi bulunamadi.");
		}
		catch (IOException e) 
		{
			Util.showWarningMessage("I/O hatasi meydana geldi. Hata mesaji:" + e.getMessage());
		}
		finally 
		{
			try
			{
				if(bufferedReader != null)  bufferedReader.close();
			}
			catch (IOException e) 
			{
				Util.showWarningMessage("Dosya kapatmada hata meydana geldi. "
						+ "Hata mesaji:" + e.getMessage());
			}
		}
	}
}
