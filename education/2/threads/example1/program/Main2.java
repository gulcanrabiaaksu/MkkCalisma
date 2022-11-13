package com.mkk.ugd.threads.example1.program;

public class Main2
{
    public static void main(String[] args)
    {
        Processor processor1 = new Processor();
        Processor processor2 = new Processor();

        processor1.start();
        processor2.start();
    }
}
