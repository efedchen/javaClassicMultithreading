package com.home.eugene.K_Semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        /*
        Semaphore sem = new Semaphore(1);
        sem.release(); //increments number of avail permits
        sem.acquire(); //decrements numb of available permits; waits if there is no permits available
        */

        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 200; i++) {
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        exec.shutdown();
        exec.awaitTermination(1, TimeUnit.DAYS);
    }
}
