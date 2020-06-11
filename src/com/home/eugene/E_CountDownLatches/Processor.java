package com.home.eugene.E_CountDownLatches;

import java.util.concurrent.CountDownLatch;

public class Processor implements Runnable {
    private CountDownLatch latch;
    private int id;

    public Processor(CountDownLatch latch, int id){
        this.latch = latch;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Started " + id);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();

        System.out.println("Ended " + id);
    }
}
