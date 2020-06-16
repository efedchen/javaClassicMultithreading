package com.home.eugene.L_CallableAndFuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        Future<?> future = exec.submit(new Callable<Void>() {
//        Future<Integer> future = exec.submit(new Callable<Integer>() {
            @Override
            public Void call() throws Exception {
                Random rand = new Random();
                int duration = rand.nextInt(4000);

                if (duration > 2000) {
                    throw new IOException("Sleeping for too long");
                }
                System.out.println("Starting");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");

                return null;
            }
        });

        exec.shutdown();

        try {
            System.out.println("Result is: " + future.get()); // .get waits till the thread finishes
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
