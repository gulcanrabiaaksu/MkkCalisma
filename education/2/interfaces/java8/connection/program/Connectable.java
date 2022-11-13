package com.mkk.ugd.interfaces.java8.connection.program;

public interface Connectable
{
    boolean openConnection();

    boolean closeConnection();

    default void sayHello()
    {
        System.out.println("Hello !");
    }

    static void merhabaDe()
    {
        System.out.println("Merhaba !");
    }
}
