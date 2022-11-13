package com.mkk.ugd.interfaces.java8.connection.program;

public class OracleConnection extends AbstractConnection
{
    public OracleConnection(String url) {
        super(url);
    }

    @Override
    public void sayHello()
    {
        super.sayHello();
        System.out.println("Oracle detayları...");
    }

    @Override
    public boolean openConnection()
    {
        /*
            Oracle'a ait bağlantı açma işlemleri yapılır.
         */

        return false;
    }

    @Override
    public boolean closeConnection()
    {
          /*
            Oracle'a ait bağlantı kapatma işlemleri yapılır.
         */

        return false;
    }
}
