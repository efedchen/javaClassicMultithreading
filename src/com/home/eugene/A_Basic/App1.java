package com.home.eugene.A_Basic;

public class App1 {

    public static class Runner extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Number of current thread: " + i
                        + ". Total number of threads " + Thread.activeCount());
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();

        Runner runner3 = new Runner();
        runner3.start();
    }
}
