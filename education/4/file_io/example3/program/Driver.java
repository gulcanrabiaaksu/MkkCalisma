package com.bt_akademi.team1.file_io.example3.program;

import com.bt_akademi.team1.utility.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Driver
{
    private static final String OKUNACAK_DOSYA = "employees.txt";

    public static void main(String[] args)
    {
        BufferedReader bufferedReader = null;

        try
        {
            bufferedReader = new BufferedReader(new FileReader(OKUNACAK_DOSYA));

            String line;
            while( ( line = bufferedReader.readLine() ) != null)
            {

            }
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
                if(bufferedReader != null) bufferedReader.close();
            }
            catch (IOException e)
            {
                Util.showGeneralException(e);
            }
        }
    }
}
