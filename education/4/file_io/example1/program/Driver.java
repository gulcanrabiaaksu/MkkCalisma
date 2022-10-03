package com.bt_akademi.team1.file_io.example1.program;

import com.bt_akademi.team1.utility.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Driver
{
    private static final String OKUNACAK_DOSYA = "employees.txt";
    private static final String YAZILACAK_DOSYA = "employeesCopy.txt";

    public static void main(String[] args)
    {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try
        {
            fileInputStream = new FileInputStream(OKUNACAK_DOSYA);
            System.out.println(OKUNACAK_DOSYA + " dosyası okundu.");

            fileOutputStream = new FileOutputStream(YAZILACAK_DOSYA);
            System.out.println(YAZILACAK_DOSYA + " dosyası oluşturuldu.");

            byte b;
            while(  (b = (byte)fileInputStream.read()) != -1 )
            {
                fileOutputStream.write(b);
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
        finally
        {
            try
            {
                if(fileInputStream != null) fileInputStream.close();

                if(fileOutputStream != null) fileOutputStream.close();
            }
            catch (IOException e)
            {
                Util.showGeneralException(e);
            }
        }
    }
}
