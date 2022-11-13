package com.mkk.ugd.interfaces.java8.connection.program;

public abstract class AbstractConnection implements Connectable
{
    private String url;

    public AbstractConnection(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AbstractConnection{" +
                "url='" + url + '\'' +
                '}';
    }
}
