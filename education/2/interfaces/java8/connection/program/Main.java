package com.mkk.ugd.interfaces.java8.connection.program;

public class Main
{
    private static final String ORACLE_URL = "";
    private static String MYSQL_URL = "";

    public static void main(String[] args)
    {
        OracleConnection oracleConnection1 = new OracleConnection(ORACLE_URL);
        oracleConnection1.sayHello();

        MySQLConnection mySQLConnection1 = new MySQLConnection(MYSQL_URL);
        mySQLConnection1.sayHello();

        Connectable.merhabaDe();
    }
}
