package com.home.eugene.E_CountDownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App1 {
    public static void main(String[] args) {
        //thread safe class
        CountDownLatch cdl = new CountDownLatch(4);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Processor(cdl, i));
        }
        executorService.shutdown();

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed");
    }
}
