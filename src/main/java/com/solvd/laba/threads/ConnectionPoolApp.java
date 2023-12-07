package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolApp {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(ConnectionPoolApp.class);

    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool(5);
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Connection connection = connectionPool.getConnection();
                    LOGGER.info(Thread.currentThread().getName() + " t" + (i + 1) + " got connection: " + connection.getName());
                    Thread.sleep(1000);
                    connectionPool.releaseConnection(connection);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    Connection connection = connectionPool.getConnection();
                    LOGGER.info(Thread.currentThread().getName() + " T" + (i + 1) + " got connection: " + connection.getName());
                    Thread.sleep(3000);
                    connectionPool.releaseConnection(connection);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);

        CompletableFuture.allOf(future1, future2).join();

        executorService.shutdown();
    }
}