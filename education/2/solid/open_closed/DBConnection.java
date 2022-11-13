package com.mkk.ugd.solid.open_closed;

public class DBConnection
{
    private Connectable connectable;

    public DBConnection(Connectable connectable)
    {
        this.connectable = connectable;
    }

    public void open()
    {
        connectable.openConnection();
    }

    public void close()
    {
        connectable.closeConnection();
    }
}
