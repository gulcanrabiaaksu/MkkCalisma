package com.migros.ucg.threads.example1.program;

public class Main1
{
    public static void main(String[] args)
    {
        Processor processor1 = new Processor();
        Processor processor2 = new Processor();

        processor1.run();
        processor2.run();
    }
}
