package com.home.eugene.K_Semaphores;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    private Semaphore sem = new Semaphore(10);
    private int connections = 0;

    private Connection() {
    }

    public static Connection getInstance() {
        return instance;
    }

    public void doConnect() {
        synchronized (this) {
            connections++;
            System.out.println("Current numb of connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }
    }

    public void connect(){
        try{
            sem.acquire();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        try {
            doConnect();
        } finally {
            sem.release();
        }
    }
}
