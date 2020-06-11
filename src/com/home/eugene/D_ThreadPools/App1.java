package com.home.eugene.D_ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService exec = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            exec.submit(new Processor(i));
        }
        exec.shutdown();

        System.out.println("All tasks submitted");

        try {
            exec.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("All tasks completed. Time: " + (end - start) + "ms");
    }
}
