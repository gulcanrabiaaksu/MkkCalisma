package com.bt_akademi.team1.file_io.example2.program;

import com.bt_akademi.team1.utility.Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver
{
    private static final String OKUNACAK_DOSYA = "employees.txt";
    private static final String YAZILACAK_DOSYA = "employeesCopy2.txt";

    public static void main(String[] args)
    {
        try
        (
            FileReader fileReader = new FileReader(OKUNACAK_DOSYA);
            FileWriter fileWriter = new FileWriter(YAZILACAK_DOSYA);
        )
        {
            int ch;
            while( (ch = fileReader.read()) != -1)
            {
                fileWriter.write(ch);
            }

            System.out.println(OKUNACAK_DOSYA + " dosyasının "
                    + YAZILACAK_DOSYA + " dosyasına kopyalama işlemi tamamlandı.");
        }
        catch (FileNotFoundException e)
        {
            Util.showGeneralException(e);
        }
        catch (IOException e)
        {
            Util.showGeneralException(e);
        }
    }
}
