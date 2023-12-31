package com.solvd.laba.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static ConnectionPool instance;
    private final BlockingQueue<Connection> connections; // черга з'єднань
    private final int poolSize; // розмір
    private boolean initialized = false; // чи заповнений пул з'єднаннями

    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new LinkedBlockingQueue<>(poolSize);
    }

    public static ConnectionPool getInstance(int poolSize) {
        if (instance == null) {
            synchronized (ConnectionPool.class){
                instance = new ConnectionPool(poolSize);
            }
        }
        return instance;
    }

    private void initializeConnections() {
        for (int i = 0; i < poolSize; i++) {
            connections.offer(new Connection("Connection-" + (i + 1))); // offer додає до черги, або повертає false
        }
        initialized = true;
    }

    public Connection getConnection() throws InterruptedException {
        if (!initialized) {
            initializeConnections(); // lazy initialization
        }
        return connections.take(); // take гарантує що метод поверне з'єднання тільки тоді, коли воно доступне
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connections.offer(connection);
        }
    }
}