package com.mkk.ugd.threads.example1.program;

public class Main1
{
    public static void main(String[] args)
    {
        Processor processor1 = new Processor();
        Processor processor2 = new Processor();

        processor1.run();

        System.out.println("\n");

        processor2.run();
    }
}
