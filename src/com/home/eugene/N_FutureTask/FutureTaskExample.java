package com.home.eugene.N_FutureTask;

import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) {
        MyCallable myCallable1 = new MyCallable(1000);
        MyCallable myCallable2 = new MyCallable(5000);

        FutureTask<String> futureTask1 = new FutureTask<String>(myCallable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(myCallable2);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(futureTask1);
        executor.execute(futureTask2);

        while (true) {
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    System.out.println("Done!");
                    return;
                }
                if (!futureTask1.isDone()) {
                    System.out.println("FutureTask1 execution result: " + futureTask1.get());
                }
                System.out.println("Waiting till FutureTask2 ends the execution");

                //every 1000L ms releases get
                String s = futureTask2.get(1000L, TimeUnit.MILLISECONDS);
                if (s != null) {
                    System.out.println("FutureTask2 execution result: " + futureTask2.get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } finally {
                executor.shutdown();
            }
        }
    }
}
