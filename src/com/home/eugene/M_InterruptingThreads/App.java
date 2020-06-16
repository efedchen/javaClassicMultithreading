package com.home.eugene.M_InterruptingThreads;

import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting...");

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random ran = new Random();

                for (int i = 0; i < 1E8; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    /*
                    This chunk of code does the same - interrupts the thread
                    Bcs: any other thread can interrupt the current thread in sleep,
                    in that case InterruptedException is thrown.
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    */
                    Math.sin(ran.nextDouble());
                }
            }
        });
        th1.start();
        Thread.sleep(500);

        //its just sets a flag that method is interrupted, it doesnt interrupts the thread
        th1.interrupt();
        th1.join();

        System.out.println("Finished.");
    }
}
