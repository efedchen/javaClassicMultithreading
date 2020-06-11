package com.home.eugene.B_BasicSync;

import java.util.Scanner;

public class App1 {

    public static void main(String[] args) {
        Processor processor1 = new Processor();
        processor1.start();

        System.out.println("Press 'return' to stop");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        processor1.shutdown();
    }
}

class Processor extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        int i = 0;
        while (running) {
            System.out.println("Hello!!" + i);
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}
