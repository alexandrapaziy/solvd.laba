package com.solvd.laba.threads;


public class Connection { // mocked
    private final String name;
    private boolean isConnected;


    public Connection(String name) {
        this.name = name;
        this.isConnected = false;
    }

    public void connect() {
        isConnected = true;
    }

    public void disconnect() {
        isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getName() {
        return name;
    }
}